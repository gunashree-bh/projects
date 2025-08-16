import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = args[0].toLowerCase();
        Map<String, List<String>> map = new HashMap<>();

        // Branch-based courses
        map.put("cse", Arrays.asList(
            "Full Stack Development",
            "Cloud Computing",
            "Cybersecurity Essentials",
            "Data Structures & Algorithms",
            "Machine Learning with Python",
            "DevOps & CI/CD",
            "Operating Systems",
            "Software Architecture",
            "Big Data Analytics",
            "Blockchain Development"
        ));

        map.put("ece", Arrays.asList(
            "IoT with Arduino",
            "Digital Signal Processing",
            "Embedded Systems",
            "VLSI Design",
            "Wireless Communication",
            "Microcontroller Programming",
            "Analog & Digital Electronics",
            "FPGA-based System Design"
        ));

        map.put("mech", Arrays.asList(
            "3D Printing & Additive Manufacturing",
            "Robotics Fundamentals",
            "CAD with AutoDesk",
            "Thermal Engineering",
            "Hydraulics and Pneumatics",
            "Mechatronics",
            "Automobile Engineering",
            "CAM & CNC Programming"
        ));

        map.put("civil", Arrays.asList(
            "Smart Cities Infrastructure",
            "GIS & Remote Sensing",
            "Advanced Concrete Technology",
            "Structural Engineering",
            "AutoCAD Civil",
            "Construction Project Management",
            "Soil Mechanics",
            "Earthquake Resistant Design"
        ));

        map.put("eee", Arrays.asList(
            "Power Systems Engineering",
            "Electric Vehicle Design",
            "Smart Grids & Automation",
            "Control Systems",
            "Electrical Machines",
            "Power Electronics",
            "Energy Storage Technologies",
            "High Voltage Engineering"
        ));

        // Interest-based keywords
        map.put("ai", Arrays.asList(
            "AI for Engineers",
            "Ethical AI Design",
            "Natural Language Processing (NLP)",
            "AI in Healthcare",
            "Deep Learning with TensorFlow"
        ));

        map.put("ml", Arrays.asList(
            "Machine Learning A-Z",
            "Predictive Modeling",
            "Applied ML for Engineers",
            "Scikit-learn & Real-world ML Projects"
        ));

        map.put("data", Arrays.asList(
            "Data Science Bootcamp",
            "Big Data using Hadoop",
            "SQL and Data Warehousing",
            "Data Visualization with Power BI"
        ));

        map.put("cloud", Arrays.asList(
            "AWS Cloud Essentials",
            "Microsoft Azure Fundamentals",
            "DevOps on AWS",
            "Kubernetes for Developers"
        ));

        map.put("java", Arrays.asList(
            "Java Programming Masterclass",
            "Spring Boot Microservices",
            "Java for Web Development",
            "DSA in Java"
        ));

        map.put("web", Arrays.asList(
            "HTML/CSS/JS Web Design",
            "React JS for Beginners",
            "Frontend + Backend Integration",
            "Responsive Web UI"
        ));

        map.put("robotics", Arrays.asList(
            "Arduino Robotics",
            "Industrial Automation",
            "Robot Operating Systems (ROS)",
            "Python for Robotics"
        ));

        map.put("sustainability", Arrays.asList(
            "Sustainable Engineering Practices",
            "Green Building & LEED",
            "Eco-friendly Manufacturing",
            "Climate Action Planning"
        ));

        map.put("energy", Arrays.asList(
            "Renewable Energy Systems",
            "Solar PV Design",
            "Smart Energy Grids",
            "Wind Energy Engineering"
        ));

        map.put("iot", Arrays.asList(
            "IoT System Design",
            "Smart Home Automation",
            "IoT with Raspberry Pi",
            "Sensor Networks"
        ));

        map.put("security", Arrays.asList(
            "Cybersecurity Fundamentals",
            "Network Security & Firewalls",
            "Ethical Hacking",
            "Information Security Auditing"
        ));

        map.put("design", Arrays.asList(
            "UI/UX Design",
            "Product Design for Engineers",
            "Figma & Prototyping Tools"
        ));

        map.put("matlab", Arrays.asList(
            "MATLAB for Engineering Applications",
            "Simulation with Simulink"
        ));

        // Collect relevant courses
        List<String> recommendations = new ArrayList<>();
        for (String key : map.keySet()) {
            if (input.contains(key)) {
                recommendations.addAll(map.get(key));
            }
        }

        // Fallback option
        if (recommendations.isEmpty()) {
            recommendations.add("Introduction to Sustainable Engineering");
        }

        // Print each course
        for (String course : recommendations) {
            System.out.println(course);
        }
    }
}
