# 📘 Spring Boot Microservices Level 1 - Agenda Overview

**Video**: [Spring Boot Microservices Level 1 - Agenda](https://www.youtube.com/watch?v=y8IQb4ofjDo&list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas)  
**Channel**: Java Brains  
**Focus**: Microservices architecture with Spring Boot — structure, communication, and discovery.

---

## 🔹 What This Course Covers

- **Building a Microservices App from Scratch**
  - Start with simple Java Spring Boot services.
  - Gradually layer in real-world communication techniques.
  - Emphasis on practical workflow and clean architecture.

- **Key Concepts Introduced**
  - Service separation and independent deployability.
  - API communication between services using `RestTemplate` and `WebClient`.
  - Dynamic service discovery via **Eureka Server**.
  - Load balancing and fault tolerance (later levels introduce Hystrix and resilience tools).

---

## 🛠️ Technologies & Tools Used

- **Spring Boot**: Core framework for microservices.
- **RestTemplate / WebClient**: To manage API calls between services.
- **Eureka**: Service registry for dynamic discovery.
- **Spring Cloud**: (Introduced later) for enhancements like configuration and load balancing.

---

## 🧱 Architecture Blueprint

The project builds:
- **Three core services**: Catalog, Info, Ratings.
- Each handles a distinct domain responsibility.
- Services communicate to aggregate data for the client-facing API.

---

## 🧩 Skills You’ll Practice

- Breaking a monolithic app into smaller services.
- Designing APIs for inter-service communication.
- Centralized service registration and discovery.
- Applying best practices for microservice structuring.

---

## 🔍 Best Practices Mentioned (Later Explored)

- Avoid hardcoding service URLs — use Eureka instead.
- Prevent tight coupling between services with clean APIs.
- Prefer `WebClient` over `RestTemplate` for non-blocking calls.

---

## 📝 Mini Summary

This course walks you through building a real-world microservices system step by step. The agenda frames core concepts you'll explore: service communication, smart discovery via Eureka, and scaling services independently. It's highly practical — ideal for devs transitioning from monoliths or diving into Spring Boot microservices for the first time.

---

# 📘 Spring Boot Microservices: Why So Many Technologies?

**Video:** [Java Brains – Why So Many Technologies](https://www.youtube.com/watch?v=cZ7tUuHjiQM&list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas&index=2)  
**Duration:** 3:04  
**Topic:** Understanding the tech landscape in microservice architecture

---

## 🧩 Core Insight

Microservices introduce complexity by splitting a large application into smaller, independent components. These components need infrastructure and tools to support their behavior.

---

## 🛠️ Reasons for Many Technologies

- Microservices are **independent** units — they don’t exist in isolation and must interact with others
- Each one needs to:
  - Communicate with other services
  - Locate other services dynamically
  - Be configured separately
  - Be monitored and logged effectively
- These different responsibilities require **different technologies**

---

## 📌 Key Message

There isn’t one single tool that solves everything. That’s why the world of microservices feels tool-heavy — you’ll encounter many technologies, but each plays a specific role in making the architecture work.

---

## 🔄 Implication for Developers

Expect to learn multiple tools across domains like communication, discovery, configuration, and observability. The series will introduce each one as it becomes relevant during development.

