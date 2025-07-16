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

# 📽️ Microservices vs Service Oriented Architecture (SOA) 

## 🔍 Overview  
The video explores the nuanced differences between Microservices and Service-Oriented Architecture (SOA), debunking the myth that microservices are simply "SOA done right."

---

## 🧱 Architectural Comparison  

### 👨‍🔧 Service-Oriented Architecture (SOA)  
- Focuses on **reusability** of services across the organization  
- Often uses **Enterprise Service Bus (ESB)** for communication  
- Emphasizes **shared infrastructure** and centralized governance  
- Can grow into **monolithic integration points** due to ESB bottlenecks  

### 🧩 Microservices  
- Prioritizes **independent deployment and scalability**  
- Leverages **lightweight communication**, usually via REST APIs  
- Promotes **domain-driven design (DDD)** — each microservice owns a specific business capability  
- Encourages **polyglot persistence & tech stacks**, allowing teams freedom  

---

## 🚧 Common Misunderstanding  
> "Microservices are just small SOA services" — not true.  
The **intent**, **design philosophy**, and **communication patterns** are fundamentally different.

---

## 🗂️ Key Design Principles of Microservices  
- **Bounded Context:** Each service should encapsulate a specific domain  
- **Loose Coupling:** Services should interact through well-defined APIs without tight dependencies  
- **High Cohesion:** Functionality within a service should be tightly related  
- **Decentralized Governance:** Teams can choose tools, languages, and databases independently  

---

## ✅ Best Practices Highlighted  
- Avoid central ESBs; instead, favor **smart endpoints and dumb pipes**  
- Design around business capabilities, not technical layers  
- Maintain **independence** in deployment and scaling — critical for agility  
- Enable teams to **own their services end-to-end**, including infrastructure, CI/CD, and monitoring  

---

## 🧠 TL;DR  
Microservices diverge from SOA by embracing independence, decentralized design, and agility. Rather than simply repackaging SOA into smaller parts, microservices rethink the architecture to align with modern deployment models and organizational autonomy.

---

# 🎬 Episode 04 — Overview of the Microservices App

## 📌 Context
This video offers a **quick overview** of the application we'll build during the workshop. The focus is on its **microservices structure** and the kind of interaction expected between components.

---

## 🧩 Application Structure
The system simulates a movie catalog app and consists of **three microservices**:

### 1. 📄 Movie Info Service
- Provides information about movies: title, description, etc.

### 2. ⭐ Movie Ratings Service
- Stores ratings provided by individual users.

### 3. 📚 Movie Catalog Service
- Queries both the Info and Ratings services.
- Combines data to present a unified response per movie and user.

---

## 🔗 Service Interaction
- Services communicate via **REST calls**.
- Each service is separate and independently deployable.

---

## 🚀 Microservice Principles Introduced
- **Single Responsibility**: Each service handles one concern.
- **Independent Deployment**: Services are built and managed separately.
- **Data Aggregation**: Catalog service stitches together info and ratings.

---

Sure thing, Eidan — here’s the complete `.md` file version of the notes for **Video 5: Designing the Sample Microservices** from the Spring Boot Microservices Level 1 course. This version reflects **only what the instructor covered**, respecting the distinction that the services are still **starter projects**, not microservices yet.

---

# 🎯 Designing the Sample Microservices 
🔖 Status: Introductory setup — no microservices yet

---

## 📌 Session Focus  
Establish the foundation for the Movie Catalog App by creating three **separate Spring Boot projects**.  
These projects represent core logical modules but are **not microservices yet** — no communication or independent deployment implemented.

---

## 📦 Projects Introduced

### 🎬 Movie Info Service  
- Purpose: Store basic movie metadata (name, description)  
- Will eventually expose APIs to provide movie details  
- Initial structure created via Spring Initializr  

### ⭐ Ratings Data Service  
- Purpose: Manage user ratings associated with movies  
- Separate project intended to return rating objects keyed by movie ID  
- No external dependencies configured at this stage  

### 📂 Movie Catalog Service  
- Purpose: Construct catalog views per user  
- Workflow design:
  - Accept a `userId`
  - Use Ratings service to get rated movies
  - Use Movie Info service to get movie details
  - Combine the two in final response structure

- Target response:
  ```json
  [
    {
      "name": "Inception",
      "description": "Mind-bending thriller by Christopher Nolan",
      "rating": 4
    },
    {
      "name": "Matrix",
      "description": "Classic sci-fi with virtual worlds",
      "rating": 5
    }
  ]
  ```

---

## 🧠 Instructor Clarifications  
- These are **starter projects only**, not true microservices yet  
- Microservices qualities such as service discovery, communication, and deployment strategies will be added in later lessons  
- Each project created via [Spring Initializr](https://start.spring.io) with barebone dependencies for now

---

---

## 🔄 Next Steps (Previewed in Ending Remarks)  
- Build REST APIs for each service  
- Enable communication between them  
- Begin gradual transformation into actual microservices architecture



> # 🎯 Using RestTemplate to Call an External Microservice API  


## 📌 Session Focus  
Demonstrate how a Spring Boot service can synchronously call other microservices using Spring’s `RestTemplate`. Key takeaways:

- Instantiate and inject a `RestTemplate` bean  
- Call external REST endpoints with `getForObject` and `getForEntity`  
- Map JSON responses directly into Java POJOs  
- Handle errors and inspect full HTTP response when needed  

---

## 📦 Core Components & Code Snippet  

### 🔧 RestTemplate Configuration  
```java
@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}
```
Inject this bean into your controller or service.

### 📝 Sample Controller  
```java
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        // 1. Get hardcoded Ratings Data
        List<Rating> ratings = Arrays.asList(
                new Rating("123", 4),
                new Rating("456", 5)
        );

        // 2. Enrich each rating by fetching movie info
        return ratings.stream()
                .map(r -> {
                    Movie movie = restTemplate.getForObject(
                            "http://localhost:8082/movies/" + r.getMovieId(),
                            Movie.class
                    );
                    return new CatalogItem(movie.getName(), movie.getDescription(), r.getRating());
                })
                .collect(Collectors.toList());
    }
}
```

---

## 🧠 Key Methods  

- `getForObject(String url, Class<T> responseType)`  
  Returns only the response body as the specified type.  

- `getForEntity(String url, Class<T> responseType)`  
  Returns `ResponseEntity<T>` with status, headers, and body.  

- Other HTTP helpers: `postForObject`, `put`, `delete`, etc.

---
