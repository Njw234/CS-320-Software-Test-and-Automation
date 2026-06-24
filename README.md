- How can I ensure that my code, program, or software is functional and secure? -

  Writing thorough unit tests is the most direct answer. In this course, I built JUNit 5 test suites for Contact, Task, and Appointment
  services that validated both expected behavior and edge cases like null inputs and duplicate IDs. Testing boundaries and failure
  conditions, not just the happy path, is what actually catches bugs before they reach production.

  - How do I interpret user needs and incorporate them into a program? -
 
    Requirements have to drive the design, not the other way around. For the Contact service, the spec defined exactly
    what fields were required, what constraints applied, and what operations needed to be supported. Translating those into data validation
    and service logic meant constantly checking implmentation against requirments rather than buidling first and fitting them later.

    - How do I approach designing software? -
   
      I start by breaking the problem into the smallest meaningful units, indvidual classes and their responsibilities, then build outward.
      For this project that meant designing each service independently with clear input validation before wiring anything together. Keeping components isolated
      made testing straightforward and made bugs easier to isolate when they came up.
