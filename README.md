## Design Patterns

Design patterns are a typical solutions to specific problems. 

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