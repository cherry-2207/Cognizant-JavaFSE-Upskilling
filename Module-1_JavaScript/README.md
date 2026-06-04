# Module 1 JavaScript Exercises

Open `index.html` to run the Local Community Event Portal.

## Covered Tasks

- `index.html` loads JavaScript with `<script src="./main.js" defer></script>`.
- `main.js` logs `Welcome to the Community Portal` and alerts when the page fully loads.
- Event data uses `const`, `let`, template literals, constructors, prototypes, arrays, functions, closures, DOM manipulation, event handlers, fetch, async/await, and form validation.
- `mock-events.json` is the local mock JSON endpoint for the async exercise.
- The form submit handler logs payload details so they can be inspected in DevTools.

## Debugging Notes

Use Chrome DevTools to:

- Check Console logs for setup, filtering, registrations, and errors.
- Check Network requests for `mock-events.json` and the POST request.
- Add breakpoints inside `registerUser()`, `handleRegistrationSubmit()`, and `postRegistration()`.

## Framework Note

React or Vue can make this portal easier to maintain by splitting the event list, filters, and registration form into reusable components with predictable state updates.
