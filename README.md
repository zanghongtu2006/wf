# WF — Early-Generation Java Web Framework (Production-Hardened)

> An early-generation Java web framework originally designed and evolved as the **first internal web framework at 58.com**, serving real production traffic and iterated across multiple versions before being gradually replaced by Spring Boot.

---

## 📌 Overview

WF is a **lightweight Java web framework** designed in the early days of large-scale web development at **58.com**, one of China’s largest classified platforms.

Before Spring Boot and modern Java frameworks became mature and widely adopted, WF served as the **foundational web framework** for multiple internal systems at 58.com.  
It went through **two major iterations**, was used in real production environments, and was eventually phased out only after the Spring ecosystem became sufficiently stable and standardized.

This repository represents a **cleaned and simplified version** of that framework, preserved as an architectural and engineering reference.

---

## 🧭 Historical Context

At the time WF was created:

- Spring Boot did not yet exist or was not production-ready
- Teams needed:
  - Fast startup
  - Predictable behavior
  - Full control over request handling
  - Minimal abstraction overhead
- Existing frameworks were either too heavy or insufficiently transparent

WF was designed to fill that gap, enabling teams to **build and iterate web services quickly**, while maintaining full visibility into the runtime behavior.

---

## 🎯 Design Goals

- Explicit and understandable request lifecycle
- Minimal but sufficient abstraction
- Framework behavior that can be reasoned about without black boxes
- Ability to evolve incrementally alongside business growth
- Production stability over feature completeness

This framework was **not an academic exercise**, but a pragmatic response to real-world constraints at scale.

---

## 🏗 Architecture Overview

```
HTTP Request
     │
     ▼
┌──────────────┐
│ Bootstrap    │  Configuration loading
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ Class Scanner│  Component discovery
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ IoC Container│  Dependency wiring
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ Dispatcher   │  URL → handler mapping
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ Business Code│
└──────────────┘
```

---

## 📂 Project Structure

```
wf/
├── demo/            # Example application using the framework
├── wf/              # Core framework implementation
└── pom.xml          # Maven build configuration
```

---

## 🔑 Core Concepts Implemented

### Framework Foundations

- Custom configuration loader
- Classpath scanning and component registration
- Minimal IoC container
- Request dispatching and handler mapping

### Engineering Focus

- Deterministic behavior
- Minimal magic
- Full control over execution order
- Easy troubleshooting in production

---

## 🚀 Running the Demo

### Prerequisites

- Java 8+
- Maven

### Build and Run

```bash
git clone https://github.com/zanghongtu2006/wf.git
cd wf
mvn clean package
mvn tomcat7:run
```

Access the demo at:

```
http://localhost:8080/
```

---

## 🧠 What This Project Demonstrates

- Early-generation framework design under real production pressure
- Deep understanding of web framework internals
- Evolution path from custom frameworks to standardized ecosystems
- Trade-offs between control, simplicity, and maintainability

---

## ⚠️ Limitations & Scope

This project intentionally does **not** aim to:

- Compete with modern frameworks like Spring Boot
- Provide full security, session management, or middleware stacks
- Be production-ready today

Its value lies in **engineering insight and architectural understanding**, not modern feature parity.

---

## 📌 Why This Matters Today

Although WF itself is no longer used in production, the experience behind it is directly applicable to:

- Backend and platform engineering
- Debugging complex frameworks
- Designing internal tooling
- Performance reasoning
- Making informed architectural trade-offs

---

## 🧑‍💻 Author

**Hongtu Zang**  
Senior Backend / Platform Engineer

---

## 📄 License

MIT License
