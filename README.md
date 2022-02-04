## Design Patterns

Design patterns are a typical solutions to specific problems. 

---
Design Pattern List

**Creational Patterns**
- [x] Factory
- [x] Abstract Factory
- [x] Builder
- [x] Prototype
- [x] Singleton

**Structural Patterns**
- [x] Adapter
- [ ] Bridge
- [ ] Composite
- [ ] Decorator
- [ ] Facade
- [ ] Flyweight
- [ ] Proxy

**Behavioral Patterns**
- [ ] Chain of Responsibility
- [ ] Command
- [ ] Iterator
- [ ] Mediator
- [ ] Memento
- [ ] Observer
- [ ] State
- [ ] Strategy
- [ ] Template Method
- [ ] Visitor
 
---
#### To Do
- Review Readme, make it easier to read
- Review Prototype example, use interface instead of a concrete class

---

### Creational Design Patterns
Creational patterns are focused on object creation and reuse.

### 1. Factory
Factory separates object creation from usage.

[+] Class responsibilities are distributed (Single Responsibility Principle).

[+] Any new object type can be introduced easily (Open/Closed Principle)

[-] Code becomes more complex with new classes.

### 2. Abstract Factory
Abstract factory is a factory of factories. 
It is responsible to pick a certain factory which creates objects with related aspects.
It is one step further than the factory pattern. Abstract factory is more complex but more flexible.

[+] Class responsibilities are distributed (Single Responsibility Principle).

[+] Any new object type can be introduced easily (Open/Closed Principle)

[-] Code becomes more complex with new classes.

### 3. Builder
Builder pattern enables us to build complex objects (with a lot of fields) in an easy and clean way.

[+] Class responsibilities are distributed (Single Responsibility Principle).

[-] Additional builder classes are introduced with plan implementation, yet it's pretty lightweight with the help of libraries.

### 4. Prototype
Prototype pattern helps us to build complex objects.

[+] It provides pre-built objects instead of creating it from scratch.

[-] It gets complicated when objects are too complex and/or have circular dependencies.

### 5. Singleton
Singleton pattern enabled us to create a single instance of a class, then re-use when needed. 
Singleton class has two responsibilities; generating a single unique instance of a class, providing a global access point to that class.

[+] Guarantees there is a single instance of a class.

[-] Requires special attention in a multi-threaded environment.

[-] Since it has static methods, it is hard to unit test.

[-] Violates single responsibility principle since it has two responsibilities.


### Structural Design patterns
Structural patterns are focused on building flexible structures with objects.

### 6. Adapter
Adapter adapts incompatible classes to work together with our code. 
It's helpful when we can't change the incompatible classes such as in 3rd party libraries.

[+] Business logic is left untouched since the conversion is made outside [Single Responsibility]

[+] New adapters can be introduced without changing the existing code [Open/Closed Principle]

[-] Code becomes more complex with new classes.


