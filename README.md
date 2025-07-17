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

Sure thing, Eidan! Based on the video "[Using WebClient to make API calls](https://www.youtube.com/watch?v=F3uJyeAyv5g&list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas&index=13)" from the Spring Boot Microservices Level 1 series by Java Brains, here's a human-friendly technical summary in markdown format — ideal for your workshop notes or GitHub documentation:

---


> # 🧵 WebClient in Spring Boot Microservices

## 🎯 Overview
This video transitions API communication from `RestTemplate` to the newer, more powerful `WebClient`. WebClient is part of Spring WebFlux and supports **reactive programming** — a non-blocking, event-driven model that handles concurrency more efficiently.

---

## 🧪 Why Switch to WebClient?
- `RestTemplate` is blocking and synchronous.
- `WebClient` offers asynchronous, non-blocking HTTP calls.
- Ideal for high-throughput microservices communicating with other services.

---
`In WebFlux, when making an API call like webClient.get().retrieve().bodyToMono(Movie.class), it returns a Mono<Movie>, meaning the movie data will be available asynchronously when subscribed to and can be used later once available.`

## ⚙️ Setup & Usage

```java
// Create WebClient bean using builder
@Bean
public WebClient.Builder getWebClientBuilder() {
    return WebClient.builder();
}
```

```java
// Inject and use WebClient
@Autowired
private WebClient.Builder webClientBuilder;

Movie movie = webClientBuilder.build()
    .get()
    .uri("http://localhost:8082/movies/" + movieId)
    .retrieve()
    .bodyToMono(Movie.class)     // Reactive wrapper
    .block();                    // Optional: forces synchronous behavior
```

### Key Points
- `.retrieve()` starts the request.
- `.bodyToMono(Class)` expects a single object.
- `.block()` converts the call to synchronous — useful for hybrid legacy integration but not recommended for full-reactive apps.

---

## 🧠 Reactive Terminology
- `Mono<T>` → Represents a single async response.
- `Flux<T>` → Represents a stream of async responses.
- Non-blocking means threads aren't held up while waiting for a response.
---

## 🔁 Comparison with RestTemplate
| Feature        | RestTemplate   | WebClient         |
|----------------|----------------|-------------------|
| Blocking       | ✅ Yes          | ❌ No              |
| Reactive       | ❌ No           | ✅ Yes             |
| Future-Proof   | ❌ Legacy       | ✅ Preferred       |
| Thread Usage   | High            | Low (efficient)   |

---

## 🧳 Real-World Use Cases
- Ideal for microservice-to-microservice communication.
- Works well with reactive databases (R2DBC) and data streams.
- Reduces resource footprint under load — great for scalable services.

---


> # Why You Should Avoid Returning Lists in APIs

A quick dive into why wrapping JSON arrays in a top-level object leads to more robust, extensible, and client-friendly APIs.

## Mini Summary

When you expose a raw JSON array as the top-level response, you lose flexibility to add metadata, versioning info, error details or HATEOAS links later. Wrapping the array in an object preserves room for growth and better client/server contracts.


## 1. The Problem with Top-Level Arrays

- No place for pagination or total-count metadata  
- Hard to evolve your API without breaking existing clients  
- Error responses must use the same structure—leaving arrays makes this awkward  
- Some frameworks (Swagger/OpenAPI, code generators) expect a JSON object at the root


## 2. Impact on Clients and Tooling

- Client code generators can’t attach new fields  
- Inconsistent parsing rules across libraries (e.g., Jackson vs. Gson)  
- Swagger UI displays arrays differently—limits documentation clarity  
- Harder to inject HATEOAS links or custom headers in the payload  


## 3. The Wrapper Pattern

Instead of returning:
```json
[
  { "id": 1, "title": "Movie A" },
  { "id": 2, "title": "Movie B" }
]
```

Return a structured object:
```json
{
  "data": [
    { "id": 1, "title": "Movie A" },
    { "id": 2, "title": "Movie B" }
  ],
  "meta": {
    "totalItems": 2,
    "page": 1,
    "pageSize": 25
  },
  "links": {
    "self": "/movies?page=1",
    "next": "/movies?page=2"
  }
}
```

## 4. Real-World Benefits
- **Extensibility**: Add new fields (e.g., warnings, debug info) without client-side breaks
- **Consistency**: Same wrapper for success and error responses
- **Metadata**: Easily include paging, sorting, or custom metrics
- **HATEOAS friendly**: Central place to inject links for client navigation

## 5. Best Practices & Tips
- Always use proper HTTP status codes (200, 4xx, 5xx) alongside your JSON wrapper
- Standardize your wrapper across all endpoints for predictability
- Consider industry schemas (JSON:API, HAL) if you need hypermedia support
- Document your `meta` and `links` fields clearly in your API spec

> # Understanding Service Discovery (Spring Boot Microservices Level 1)
Service discovery lets microservices dynamically locate and communicate with each other without hard-coding endpoints. Instead of binding clients to fixed hostnames and ports, we introduce a registry that maintains live instances. This video contrasts the common “what are we doing wrong here” pitfall (tight coupling via hard-coded URLs) with client-side and server-side discovery approaches.

## What Are We Doing Wrong Here?

In our Movie Catalog service we called Movie Info like this:

```java
String url = "http://localhost:8081/movie-info/" + movieId;
MovieInfo info = restTemplate.getForObject(url, MovieInfo.class);
```

- Hard-codes host and port
- Couples client code to a specific instance
- Fails when you scale instances or change ports
- Requires manual updates on every deployment

That fragility and maintenance burden is exactly why we need service discovery—to decouple logical service names from physical locations.


## Two Service Discovery Approaches

### 1. Client-Side Discovery

Clients query a registry directly, pick an instance, then call it:

1. **Service Registration**  
   Each service registers under a logical name (e.g. “movie-info-service”) on startup.
2. **Lookup & Invocation**
   ```java
   @Autowired
   private DiscoveryClient discoveryClient;

   List<ServiceInstance> instances = discoveryClient.getInstances("movie-info-service");
   ServiceInstance instance = instances.get( new Random().nextInt(instances.size()) );
   String baseUrl = instance.getUri().toString();
   MovieInfo info = restTemplate.getForObject(baseUrl + "/movie-info/" + movieId, MovieInfo.class);
   ```
3. **Load Balancing**  
   Client-side logic (round-robin, random) picks which instance to call.

Pros
- No extra network hop
- Full control over load-balancing strategy

Cons
- All clients must embed discovery logic
- Registry API becomes a direct dependency

---

### 2. Server-Side Discovery

A dedicated router or proxy handles discovery for clients:

1. **Registration**  
   Services still register with a discovery server.
2. **Client Call**  
   Clients issue normal HTTP requests to a gateway (e.g. `http://gateway/movie-info/{id}`).
3. **Routing & Load-Balancing**  
   The gateway queries the registry, selects an instance, and forwards the request.

Pros
- Clients remain simple HTTP callers
- Centralized routing, easier to secure and monitor

Cons
- Adds an extra network hop
- Gateway itself needs to be highly available

---

## Key Takeaways & Best Practices

- Never hard-code hostnames or ports in client code.
- Register and deregister services automatically (on startup/shutdown).
- Leverage health checks so only healthy instances appear in the registry.
- Use client libraries (Spring Cloud Netflix, Spring Cloud Gateway) to abstract discovery logic.
- Combine discovery with resilience patterns: timeouts, retries, circuit breakers (Hystrix, Resilience4j).


### Why Hardcoded URLs are bad?
- Changes require code updates
- Dynamic URLs in the cloud -> When we deploy microservices on cloud for example Heroku, then we don't have any idea
  what would be the API URLs
- Load Balancing
- Multiple environments -> In real-world applications, it's common to deploy across multiple environments
  (e.g., development, staging, production). Hardcoding URLs makes it difficult to handle different
  environments for several reasons

So, because of all these drawbacks, we have `Service Discovery (A Pattern)` which helps microservices discover and talk to each other

### Service Discovery in Spring Cloud

![Alt text](images/service-discovery-daigram.png)

Service discovery in Spring Cloud plays a crucial role in systems following a microservices architecture, as shown in the diagram. Here’s how it works:

- **Discovery Server (Registry)** : At the heart of service discovery is a discovery server, like **Eureka** (a widely-used component in Spring Cloud). This server acts as a registry where all the microservices register themselves. It's like a phonebook for services.

- **Service Registration** : Each microservice (such as **SRV 1**, **SRV 2**, and **SRV 3** in the diagram) registers its details (like hostname, port, etc.) with the discovery server. This allows other services to locate it dynamically rather than relying on hardcoded configurations.

- **Client-Side Service Discovery** : When the client (in this case, the **CLIENT** box in the diagram) needs to communicate with a specific service, it queries the discovery server to get the relevant information. This ensures flexibility and scalability, as services can be added or removed without affecting the client directly.

- **Load Balancing** : If multiple instances of a service exist (e.g., several instances of **SRV 1**), the discovery server can provide the client with all available instances. Tools like **Ribbon** (Spring Cloud Load Balancer) help to distribute requests across these instances efficiently.

- **Dynamic Updates** : The registry is updated dynamically, so if a service goes down or is brought up, the discovery server maintains an accurate and current list of available services.

Now, what happens in the above diagram for `Client Side Service Discovery`, each of those `services` which want to be discovered by the `Client`, register themselves with that `Discovery Server`.
In other words, `Service Discovery` is like a phone book guy which is maintaining a `Phone Book` and all these people are kind of
providing the entries into the phone book. Whoever needs to make a call looks up the phone book and gets the address

> Remember : Spring Cloud uses the Client Side Service Discovery

> # 📘 Eureka Service Discovery

## 🎯 What Is Eureka Server?

> Think of Eureka Server as the “address book” for microservices in Spring Cloud applications.

In a cloud-native app like an online food delivery platform, you might have:

- 🧾 **Order Service**: Places and tracks orders
- 🍽️ **Restaurant Service**: Manages menus and availability
- 🚚 **Delivery Service**: Coordinates delivery agents

Each service runs independently, but they need to **find and talk to each other dynamically**. That’s where Eureka Server comes in — instead of hardcoding IPs or URLs (which can change), services use Eureka for registration and discovery.

## 🔄 How It Works (User Insight)

- **Service Registration**  
  Each microservice registers itself with Eureka Server upon startup (hostnames, ports, metadata).

- **Service Discovery**  
  When one service wants to communicate with another, it asks Eureka for the current address — avoiding brittle, hardcoded paths.

### 🧩 Why Use Eureka?

- Microservices in cloud environments scale up/down unpredictably.
- Their network locations (host:port) often change.
- Hardcoding service addresses breaks dynamic scaling.
- Eureka maintains a **live registry** and allows **runtime service lookups**.

### 🏗 Origins & Purpose

- Eureka was built by **Netflix** to support its massive microservice architecture.
- Provides:
    - Dynamic discovery
    - Heartbeat checks
    - Resilience features like **self-preservation mode**

### ☕ Spring Boot Integration 
- Spring Cloud offers out-of-the-box support via annotations and auto-config.
- Developers can turn a plain Spring Boot app into a Eureka registry with minimal effort.
- The current video does **not** show code — it sets the stage conceptually.

> # 🚀 Starting a Eureka Server

This video walks you through creating a **Eureka Server** using Spring Boot. You’ll build a discovery service, enable Eureka, configure essential settings, and verify the dashboard — all within scope.

## 📦 Step-by-Step Guide

### 1️⃣ Create a New Spring Boot Project

- Use [Spring Initializr](https://start.spring.io)
- Add the following **dependency**:  
  `spring-cloud-starter-netflix-eureka-server`
- Set the project name as `discovery-server`

---

### 2️⃣ Enable Eureka Server

In your main class:

```java
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceApplication.class, args);
    }
}
```

🧠 The annotation `@EnableEurekaServer` activates Eureka's registry logic — no controllers or REST endpoints needed.

---

### 3️⃣ Understand Default Behavior

> ⚠️ **Important note:** Every Eureka Server is also treated as a Eureka Client by default.

That means it will try to **register itself** to another registry — or to its own dashboard if no other registry exists.

---

### 4️⃣ Configure `application.properties` to Avoid Self-Registration

```properties
# Tell Eureka Server to stop acting like a client (Eureka)
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

🔍 Explanation:
- `register-with-eureka: false` tells the server **not to register itself** as a client.
- `fetch-registry: false` prevents it from looking for other Eureka servers (discovery is disabled).

### 5️⃣ Launch and Verify
- Run the app locally (via IDE or terminal).
- Open: [`http://localhost:8761`](http://localhost:8761)
- You’ll see the **Eureka dashboard** — no services registered yet, which is expected.


> “Think of Eureka Server as the **receptionist** in a company.  
> Visitors (microservices) come in and write their details in the visitor log.  
> Other visitors can ask the receptionist for someone’s location — and get directed.”

># 🎥 Creating Eureka Clients
Convert three standalone microservices into Eureka-aware clients in just a few steps. After adding a single dependency and minimal configuration, each service will auto-register with your running Eureka Server and appear in the dashboard.

## 🔧 Prerequisite
- A Eureka Server up and running at `http://localhost:8761` (see Video #19).

## 🚀 Step-by-Step Guide

### 1. Add the Eureka Client Dependency

In each microservice’s `pom.xml`, include:

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<dependencyManagement>
<dependencies>
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-dependencies</artifactId>
    <version>${spring-cloud.version}</version>
    <type>pom</type>
    <scope>import</scope>
  </dependency>
</dependencies>
</dependencyManagement>

<!-- Add this in properties tag just under java version property-->
<spring-cloud.version>Greenwich.RELEASE</spring-cloud.version>
```

This brings in the client-side service-registration and discovery hooks.



### 2. Enable Eureka Client

In your main application class, add:

```java
@SpringBootApplication
@EnableEurekaClient
public class MovieInfoServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(MovieInfoServiceApplication.class, args);
  }
}
```

- `@EnableEurekaClient` activates Eureka registration.
- Note: With the starter on the classpath, Spring Boot can also auto-detect client behavior even without this annotation.

### 3. Configure Each Service

Create or update `application.yml` (or `.properties`) in each microservice:

```yaml
spring:
  application:
    name: movie-info-service   # Unique service ID

server:
  port: 8081                  # Change per service (e.g., 8082, 8083 for others)

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

- `spring.application.name` is the identifier shown in Eureka.
- Point `defaultZone` to your Eureka Server’s `/eureka` endpoint.

---

### 4. Start & Verify Registration

1. Launch your Eureka Server (if not already running).
2. Start each microservice (`mvn spring-boot:run` or via IDE).
3. Open `http://localhost:8761` in your browser.

You should now see entries for:
- `MOVIE-INFO-SERVICE`
- `MOVIE-CATALOG-SERVICE`
- `RATING-DATA-SERVICE`

Each listed with its instance ID, status (UP), and port.

## 💡 Key Takeaways & Tips

- Ensure **unique service names** to avoid collisions in the registry.
- Verify ports before startup—Eureka won’t register two instances on the same port.
- You can omit `@EnableEurekaClient` if you prefer convention-over-configuration; the starter will pick it up.
- For production, secure your Eureka endpoints and consider timeouts/retry settings under `eureka.instance` and `eureka.client`.


```  
All set! Your microservices are now Eureka clients, ready for dynamic discovery and resilient inter-service communication.  
```