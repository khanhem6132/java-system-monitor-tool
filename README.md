# Java System Diagnostic & Monitoring Tool

A lightweight **Command Line Interface (CLI) system monitoring and diagnostic tool built with Java**.

This tool helps **developers, IT support engineers, and system administrators** monitor system performance, analyze resource usage, and generate diagnostic reports directly from the terminal.

The project demonstrates how Java can interact with the **Operating System, CPU, RAM, disk, and running processes** to provide useful system insights.

---

# Features

## System Information

Displays basic system information such as:

* CPU usage
* RAM usage and memory status
* Operating system name and version
* Java runtime version
* Computer hostname

---

## System Monitoring

Provides real-time monitoring of important system resources:

* CPU usage chart
* RAM usage chart
* Disk usage monitoring
* Continuous real-time system monitoring

Example visualization:

CPU | ███████████ 52%
RAM | █████████████ 63%

---

## Real-Time Monitoring Mode

Displays live system statistics continuously.

Example output:

REAL-TIME SYSTEM MONITOR

CPU  | ███████████ 55%
RAM  | █████████████ 61%
DISK | ███████ 32%

---

## Diagnostics

Performs automatic system diagnostics:

* AI-style system health analysis
* Full system health check
* Resource usage evaluation

Helps identify potential system performance issues.

---

## Reporting

The tool can generate reports for later analysis:

* Export system information to file
* Generate diagnostic reports
* Save system logs

Example output file:

system_log.txt

---

# Project Structure

```
system-monitor-tool
│
├── SystemMonitor.java
├── SystemDashboard.java
├── SystemInfo.java
├── DiskInfo.java
├── NetworkInfo.java
├── NetworkSpeedMonitor.java
├── RealTimeMonitor.java
├── ProcessMonitor.java
├── SystemReportGenerator.java
├── LoggerUtil.java
│
├── system_log.txt
├── LICENSE
└── README.md
```

---

# Technologies Used

This project uses the following technologies:

* **Java**
* **Java Management API**
* **Command Line Interface (CLI)**
* **System resource monitoring**
* **File I/O for logging and reports**

---

# How to Run

1. Clone the repository

```
git clone https://github.com/yourusername/java-system-monitor-tool.git
```

2. Navigate to the project folder

```
cd java-system-monitor-tool
```

3. Compile the project

```
javac *.java
```

4. Run the system monitor

```
java SystemMonitor
```

---

# Use Cases

This tool can be useful for:

* IT Support Engineers diagnosing system problems
* System Administrators monitoring resource usage
* Developers analyzing performance issues
* Students learning how system monitoring works in Java

---

# Future Improvements

Possible improvements for the next versions:

* Network traffic monitoring
* Process usage visualization
* Export reports to JSON / CSV
* Interactive command-line menu
* Cross-platform system metrics

---

# Author

Tran Gia Khanh
Information Technology Student
University of Economics and Finance (UEF)

---

# License

This project is licensed under the MIT License.
