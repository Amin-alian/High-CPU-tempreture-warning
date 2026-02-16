# 🔥 High-CPU Temperature Warning

> **A robust Java-based system monitoring solution to detect and warn about dangerously high CPU temperatures in real-time**

---

## 📋 Table of Contents

- [Overview](#overview)
- [Key Features](#key-features)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Architecture](#architecture)
- [API Reference](#api-reference)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

---

## 🎯 Overview

**High-CPU Temperature Warning** is a comprehensive Java application designed to monitor system CPU temperatures in real-time and provide intelligent alerts when temperatures exceed critical thresholds. This project combines performance monitoring with proactive warning systems to prevent hardware damage, system throttling, and unexpected shutdowns.

Whether you're running intensive computations, managing server infrastructure, or developing high-performance applications, this tool helps you maintain optimal system health by continuously tracking thermal metrics.

---

## ✨ Key Features

### 🌡️ Real-Time Temperature Monitoring
- **Continuous CPU Temperature Tracking**: Monitor CPU temperatures with high-frequency polling
- **Multi-Core Support**: Track individual and aggregate core temperatures
- **Historical Data**: Maintain temperature history for trend analysis and reporting

### ⚠️ Intelligent Alert System
- **Customizable Thresholds**: Set multiple warning levels (caution, critical, emergency)
- **Multi-Channel Notifications**: Support for console logs, file outputs, and system alerts
- **Smart Throttling Detection**: Identify when the system activates thermal throttling
- **Alert Deduplication**: Prevent alert fatigue with intelligent notification filtering

### 📊 Reporting & Analytics
- **Temperature Statistics**: Min, max, and average temperature calculations
- **Performance Impact Analysis**: Correlate temperature spikes with system performance
- **Export Capabilities**: Generate reports in multiple formats for analysis

### 🛠️ System Integration
- **Cross-Platform Compatibility**: Works on Windows, Linux, and macOS
- **Lightweight Architecture**: Minimal resource overhead for monitoring
- **Background Service Support**: Run as a daemon or scheduled task

---

## 🚀 Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- **Java 11** or higher
- **Apache Maven 3.6.0** or higher
- **Administrative/Root Access** (required for CPU temperature access on some systems)

### Quick Start

```bash
# Clone the repository
git clone https://github.com/Amin-alian/High-CPU-tempreture-warning.git
cd High-CPU-tempreture-warning

# Build the project
./mvnw clean package

# Run the application
java -jar target/high-cpu-temperature-warning-*.jar
```

---

## 📦 Installation

### 1. **From Source**

```bash
# Clone the repository
git clone https://github.com/Amin-alian/High-CPU-tempreture-warning.git
cd High-CPU-tempreture-warning

# Build with Maven
./mvnw clean install

# The compiled JAR will be available in the target/ directory
```

### 2. **Using Maven Wrapper (Recommended)**

The project includes Maven Wrapper for consistency across environments:

```bash
# On Linux/Mac
./mvnw clean package -DskipTests

# On Windows
mvnw.cmd clean package -DskipTests
```

### 3. **System Integration**

**Linux/Unix (systemd):**
```bash
sudo cp high-cpu-temperature-warning.jar /opt/
sudo nano /etc/systemd/system/cpu-temp-monitor.service
```

**Windows (Task Scheduler):**
- Create a scheduled task running: `java -jar C:\path\to\high-cpu-temperature-warning.jar`

---

## 💻 Usage

### Basic Usage

```bash
java -jar high-cpu-temperature-warning.jar
```

### Command Line Options

```bash
# With custom configuration file
java -jar high-cpu-temperature-warning.jar --config=config.properties

# Set warning threshold (in Celsius)
java -jar high-cpu-temperature-warning.jar --warning-threshold=75

# Set critical threshold (in Celsius)
java -jar high-cpu-temperature-warning.jar --critical-threshold=85

# Enable debug logging
java -jar high-cpu-temperature-warning.jar --debug

# Specify log output file
java -jar high-cpu-temperature-warning.jar --log-file=/var/log/cpu-temp.log

# Set monitoring interval (in seconds)
java -jar high-cpu-temperature-warning.jar --check-interval=5
```

### Example Output

```
[INFO] CPU Temperature Monitor - Started
[INFO] System: Linux 5.10.0 - Intel Core i7-8700K
[INFO] Number of cores: 6
[INFO] Monitoring interval: 10 seconds

[INFO] 2024-01-15 10:23:45 - Current temperature: 45°C (Normal)
[INFO] 2024-01-15 10:23:55 - Current temperature: 52°C (Normal)
[INFO] 2024-01-15 10:24:05 - Current temperature: 68°C (Normal)
[WARN] 2024-01-15 10:24:15 - Current temperature: 76°C (WARNING - Threshold: 75°C)
[ERROR] 2024-01-15 10:24:25 - Current temperature: 87°C (CRITICAL - Threshold: 85°C)
```

---

## ⚙️ Configuration

### Configuration File (config.properties)

Create a `config.properties` file in the application directory:

```properties
# Temperature Thresholds (in Celsius)
warning.threshold=75
critical.threshold=85
emergency.threshold=95

# Monitoring Settings
monitoring.interval=10
monitoring.enabled=true
monitoring.average-samples=5

# Alert Settings
alert.enabled=true
alert.console=true
alert.file=true
alert.file-path=/var/log/cpu-temp-alerts.log
alert.system-notification=true

# Performance
monitoring.threads=2
buffer.size=1000

# System Commands (platform-specific)
temperature.command.linux=cat /sys/class/thermal/thermal_zone0/temp
temperature.command.windows=wmic os get SystemUptime
```

### Environment Variables

```bash
export CPU_TEMP_WARNING=75
export CPU_TEMP_CRITICAL=85
export CPU_TEMP_CHECK_INTERVAL=10
export CPU_TEMP_LOG_FILE=/var/log/cpu-monitor.log

java -jar high-cpu-temperature-warning.jar
```

---

## 🏗️ Architecture

### Project Structure

```
High-CPU-tempreture-warning/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── monitor/
│   │   │   │       ├── TemperatureMonitor.java
│   │   │   │       ├── AlertSystem.java
│   │   │   │       ├── SystemMetrics.java
│   │   │   │       └── utils/
│   │   │   └── Application.java
│   │   └── resources/
│   │       └── config.properties
│   └── test/
│       └── java/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

### Component Overview

| Component | Purpose |
|-----------|---------|
| **TemperatureMonitor** | Core monitoring engine for CPU temperature tracking |
| **AlertSystem** | Handles alert generation and multi-channel notification |
| **SystemMetrics** | Collects and analyzes system performance data |
| **Application** | Main entry point and orchestrator |

---

## 📡 API Reference

### TemperatureMonitor

```java
// Initialize monitor
TemperatureMonitor monitor = new TemperatureMonitor();

// Get current temperature
double currentTemp = monitor.getCurrentTemperature();

// Get average temperature (over last N samples)
double avgTemp = monitor.getAverageTemperature(5);

// Get maximum recorded temperature
double maxTemp = monitor.getMaxTemperature();

// Set warning threshold
monitor.setWarningThreshold(75);

// Start monitoring
monitor.start();

// Stop monitoring
monitor.stop();
```

### AlertSystem

```java
// Create alert system
AlertSystem alertSystem = new AlertSystem();

// Send alert
alertSystem.sendAlert(AlertLevel.CRITICAL, "CPU temperature exceeded critical threshold");

// Register custom listener
alertSystem.addAlertListener(customListener);

// Enable/disable specific alert channels
alertSystem.enableConsoleAlerts(true);
alertSystem.enableFileAlerts(true);
```

---

## 🔧 Troubleshooting

### Issue: "Permission Denied" when accessing temperature data

**Solution:**
- Run with elevated privileges: `sudo java -jar high-cpu-temperature-warning.jar`
- On Linux, ensure your user is in the `thermal_zone` group

### Issue: Temperature shows 0°C or "Unknown"

**Solution:**
- Verify your system supports thermal monitoring
- Check that the temperature sensor drivers are installed
- Try the manual command in config.properties
- Check logs for specific error messages

### Issue: High Memory Usage

**Solution:**
- Reduce monitoring frequency: `--check-interval=30`
- Reduce buffer size in config.properties
- Check for memory leaks: enable debug mode and review logs

### Issue: Alerts not being sent

**Solution:**
- Verify alert settings in configuration file
- Check log file for errors
- Ensure file paths have write permissions
- Verify system notification service is running (on Windows/Mac)

---

## 🤝 Contributing

We welcome contributions! Here's how you can help:

### Development Setup

```bash
# Fork the repository
# Clone your fork
git clone https://github.com/YOUR-USERNAME/High-CPU-tempreture-warning.git
cd High-CPU-tempreture-warning

# Create a feature branch
git checkout -b feature/amazing-feature

# Make your changes and commit
git commit -m 'Add amazing feature'

# Push to your fork
git push origin feature/amazing-feature

# Create a Pull Request
```

### Coding Standards

- Follow Google Java Style Guide
- Write unit tests for new features
- Update documentation for API changes
- Use meaningful commit messages

### Reporting Issues

When reporting issues, please include:
- Operating System and version
- Java version
- CPU model
- Steps to reproduce
- Expected vs. actual behavior
- Log files and error messages

---

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

## 📞 Support

For issues, questions, or suggestions:

- 🐛 **Report Issues**: [GitHub Issues](https://github.com/Amin-alian/High-CPU-tempreture-warning/issues)
- 💬 **Discussions**: [GitHub Discussions](https://github.com/Amin-alian/High-CPU-tempreture-warning/discussions)
- 📧 **Contact**: Create an issue with the question label

---

## 🌟 Acknowledgments

- Built with ❤️ using Java and Maven
- Inspired by the need for proactive system health monitoring
- Thanks to all contributors and users

---

**⭐ If this project helped you, please consider giving it a star!**

---

*Last Updated: February 2026*