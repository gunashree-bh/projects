from flask import Flask, request, jsonify
from flask_mysqldb import MySQL
from flask_cors import CORS
import subprocess

app = Flask(__name__)
CORS(app)

# MySQL configuration
app.config['MYSQL_HOST'] = 'localhost'
app.config['MYSQL_USER'] = 'root'
app.config['MYSQL_PASSWORD'] = 'Gagu@1529'
app.config['MYSQL_DB'] = 'greenskill'

mysql = MySQL(app)

# Temporary in-memory store to track previous recommendations
user_sessions = {}

@app.route('/recommend', methods=['POST'])
def recommend():
    data = request.get_json()
    name = data['name']
    branch = data['branch']
    interests = data['interests']
    another = data.get('another', False)

    # Save student input to MySQL only for the first time
    if not another:
        cur = mysql.connection.cursor()
        cur.execute("INSERT INTO students3(name, branch, interests) VALUES (%s, %s, %s)", (name, branch, interests))
        mysql.connection.commit()
        cur.close()

    # Call Java program to get recommendations
    input_data = f"{branch} {interests}"
    result = subprocess.run(['java', '-cp', '../recommender-java', 'Main', input_data], capture_output=True, text=True)

    all_courses = result.stdout.strip().split('\n')

    if name not in user_sessions or not another:
        user_sessions[name] = set()

    already_sent = user_sessions[name]
    remaining_courses = [c for c in all_courses if c not in already_sent]

    if not remaining_courses:
        return jsonify({'recommendations': ["✅ You've already seen all matching courses. Try new interests!"]})

    next_course = remaining_courses[0]
    already_sent.add(next_course)

    return jsonify({'recommendations': [next_course]})

if __name__ == '__main__':
    app.run(debug=True)
