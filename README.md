# 🔥 High-CPU Temperature Warning

> **A robust Java-based system monitoring solution to detect and warn about dangerously high CPU temperatures in real-time**

---

## 📋 Table of Contents

- [Overview](#Overview)
- [Key Features](#Key-Features)
- [Getting Started](#Getting-Started)
- [Installation](#Installation)
- [Usage](#Usage)
- [Configuration](#Configuration)
- [Architecture](#Architecture)
- [API Reference](#Api-Reference)
- [Troubleshooting](#Troubleshooting)
- [Contributing](#Contributing)
- [License](#License)

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
