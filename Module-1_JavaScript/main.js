console.log("Welcome to the Community Portal");

const featuredEventName = "Community Music Night";
const featuredEventDate = "2026-06-15";
let featuredSeats = 5;

const eventInfo = `${featuredEventName} is scheduled on ${featuredEventDate}. Seats available: ${featuredSeats}`;

class Event {
  constructor(id, name, date, seats, category, location, image = "./static/food-festival.jpg") {
    this.id = id;
    this.name = name;
    this.date = date;
    this.seats = seats;
    this.category = category;
    this.location = location;
    this.image = image;
  }
}

Event.prototype.checkAvailability = function () {
  return new Date(this.date) >= new Date() && this.seats > 0;
};

const events = [
  new Event(1, "Community Music Night", "2026-06-15", 5, "Music", "City Hall"),
  new Event(2, "Workshop on Baking", "2026-06-20", 12, "Workshop", "Community Center"),
  new Event(3, "Food Festival", "2026-06-25", 20, "Food", "River Park"),
  new Event(4, "Volunteering Drive", "2026-06-12", 8, "Service", "Community Center", "./static/volunteering.jpg"),
  new Event(5, "Past Cleanup Campaign", "2025-05-01", 10, "Service", "River Park"),
  new Event(6, "Full Guitar Session", "2026-06-30", 0, "Music", "City Hall"),
];

const state = {
  selectedCategory: "all",
  selectedLocation: "all",
  searchTerm: "",
  totalRegistrations: 0,
};

function addEvent(eventList, event) {
  eventList.push(event);
  return eventList;
}

function createCategoryRegistrationTracker(category) {
  let total = 0;

  return function () {
    total++;
    console.log(`${category} registrations: ${total}`);
    return total;
  };
}

const trackMusicRegistrations = createCategoryRegistrationTracker("Music");

function filterEventsByCategory(eventList, category = "all", callback = (event) => event) {
  const clonedEvents = [...eventList];
  return clonedEvents
    .filter((event) => category === "all" || event.category === category)
    .map(callback);
}

function filterEvents(eventList, predicate) {
  return [...eventList].filter(predicate);
}

function isVisibleEvent(event) {
  if (!event.checkAvailability()) {
    return false;
  }

  if (state.selectedCategory !== "all" && event.category !== state.selectedCategory) {
    return false;
  }

  if (state.selectedLocation !== "all" && event.location !== state.selectedLocation) {
    return false;
  }

  if (state.searchTerm && !event.name.toLowerCase().includes(state.searchTerm)) {
    return false;
  }

  return true;
}

function getAvailabilityMessage(event) {
  if (event.checkAvailability()) {
    return `${event.seats} seats available`;
  } else {
    return "Past or full event hidden from the active list";
  }
}

function registerUser(eventId) {
  try {
    const selectedEvent = events.find((event) => event.id === Number(eventId));

    if (!selectedEvent) {
      throw new Error("Event not found.");
    }

    if (!selectedEvent.checkAvailability()) {
      throw new Error("This event is full or no longer available.");
    }

    selectedEvent.seats--;
    featuredSeats--;
    state.totalRegistrations++;

    if (selectedEvent.category === "Music") {
      trackMusicRegistrations();
    }

    console.log("Registered for:", selectedEvent.name);
    renderEvents();
    populateEventOptions();
    return selectedEvent;
  } catch (error) {
    console.error("Registration failed:", error.message);
    alert(error.message);
    return null;
  }
}

function cancelRegistration(eventId) {
  const selectedEvent = events.find((event) => event.id === Number(eventId));

  if (selectedEvent) {
    selectedEvent.seats++;
    console.log("Cancelled registration for:", selectedEvent.name);
    renderEvents();
    populateEventOptions();
  }
}

function createEventCard(event) {
  const { id, name, date, seats, category, location, image } = event;
  const card = document.createElement("article");
  card.className = "eventCard";
  card.style.display = "none";

  const title = document.createElement("h3");
  title.textContent = name;

  const eventImage = document.createElement("img");
  eventImage.className = "event-image";
  eventImage.src = image;
  eventImage.alt = name;

  const details = document.createElement("p");
  details.textContent = `${category} event at ${location} on ${date}. ${getAvailabilityMessage(event)}`;

  const registerButton = document.createElement("button");
  registerButton.className = "cta-button";
  registerButton.type = "button";
  registerButton.textContent = "Register";
  registerButton.onclick = () => registerUser(id);

  const cancelButton = document.createElement("button");
  cancelButton.className = "secondaryButton";
  cancelButton.type = "button";
  cancelButton.textContent = "Cancel";
  cancelButton.onclick = () => cancelRegistration(id);

  card.append(eventImage, title, details, registerButton, cancelButton);
  return card;
}

function renderEvents() {
  const container = document.querySelector("#eventContainer");
  container.innerHTML = "";

  const visibleEvents = events.filter((event) => {
    if (!event.checkAvailability()) {
      return false;
    }

    return isVisibleEvent(event);
  });

  visibleEvents.forEach((event) => {
    const card = createEventCard(event);
    container.append(card);

    if (window.jQuery) {
      $(card).fadeIn(250);
    } else {
      card.style.display = "block";
    }
  });
}

function populateEventOptions() {
  const select = document.querySelector("#selectedEvent");
  select.innerHTML = "";

  events.filter((event) => event.checkAvailability()).forEach((event) => {
    const option = document.createElement("option");
    option.value = event.id;
    option.textContent = `${event.name} (${event.seats} seats)`;
    select.append(option);
  });
}

function showObjectAndArrayExamples() {
  const objectOutput = document.querySelector("#objectOutput");
  const arrayOutput = document.querySelector("#arrayOutput");
  const firstEventEntries = Object.entries(events[0])
    .map(([key, value]) => `${key}: ${value}`)
    .join("\n");

  const musicEvents = events.filter((event) => event.category === "Music");
  const formattedCards = events.map((event) => `${event.category} on ${event.name}`);

  objectOutput.textContent = `Object.entries() for first event:\n${firstEventEntries}`;
  arrayOutput.textContent = [
    "Music events from filter():",
    ...musicEvents.map((event) => event.name),
    "",
    "Formatted cards from map():",
    ...formattedCards,
  ].join("\n");
}

function validateForm(form) {
  const { name, email, eventId } = form.elements;
  let isValid = true;

  document.querySelector("#nameError").textContent = "";
  document.querySelector("#emailError").textContent = "";
  document.querySelector("#eventError").textContent = "";

  if (!name.value.trim()) {
    document.querySelector("#nameError").textContent = "Name is required.";
    isValid = false;
  }

  if (!email.value.includes("@")) {
    document.querySelector("#emailError").textContent = "Enter a valid email address.";
    isValid = false;
  }

  if (!eventId.value) {
    document.querySelector("#eventError").textContent = "Choose an event.";
    isValid = false;
  }

  return isValid;
}

function postRegistration(payload) {
  console.log("Submitting registration payload:", payload);

  return new Promise((resolve) => {
    setTimeout(resolve, 900);
  }).then(() =>
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(payload),
    }),
  );
}

function handleRegistrationSubmit(event) {
  event.preventDefault();
  console.log("Form submit started.");

  const form = event.target;
  const status = document.querySelector("#formStatus");

  if (!validateForm(form)) {
    status.textContent = "Please fix the highlighted errors.";
    return;
  }

  const { name, email, eventId } = form.elements;
  const selectedEvent = registerUser(eventId.value);

  if (!selectedEvent) {
    status.textContent = "Registration could not be completed.";
    return;
  }

  const payload = {
    name: name.value.trim(),
    email: email.value.trim(),
    eventId: Number(eventId.value),
    eventName: selectedEvent.name,
  };

  status.textContent = "Submitting registration...";

  postRegistration(payload)
    .then((response) => response.json())
    .then((data) => {
      console.log("Fetch response:", data);
      status.textContent = "Registration submitted successfully.";
      form.reset();
    })
    .catch((error) => {
      console.error("Fetch request failed:", error);
      status.textContent = "Could not submit registration. Check Network tab.";
    });
}

function loadMockEventsWithThen() {
  return fetch("./mock-events.json")
    .then((response) => {
      if (!response.ok) {
        throw new Error("Mock JSON request failed.");
      }

      return response.json();
    })
    .catch((error) => {
      console.error("Then/catch fetch error:", error);
      return [];
    });
}

async function loadMockEventsAsync() {
  const spinner = document.querySelector("#loadingSpinner");
  const output = document.querySelector("#remoteOutput");

  spinner.classList.remove("hidden");
  output.textContent = "";

  try {
    const remoteEvents = await loadMockEventsWithThen();
    output.textContent = JSON.stringify(remoteEvents, null, 2);
  } catch (error) {
    output.textContent = error.message;
  } finally {
    spinner.classList.add("hidden");
  }
}

function attachEventHandlers() {
  document.querySelector("#categoryFilter").onchange = (event) => {
    state.selectedCategory = event.target.value;
    renderEvents();
  };

  document.querySelector("#locationFilter").onchange = (event) => {
    state.selectedLocation = event.target.value;
    renderEvents();
  };

  document.querySelector("#searchInput").addEventListener("keydown", (event) => {
    window.setTimeout(() => {
      state.searchTerm = event.target.value.toLowerCase();
      renderEvents();
    }, 0);
  });

  document.querySelector("#registrationForm").addEventListener("submit", handleRegistrationSubmit);
  document.querySelector("#loadRemoteEvents").addEventListener("click", loadMockEventsAsync);

  if (window.jQuery) {
    $("#registerBtn").click(function () {
      $(".eventCard").fadeOut(150).fadeIn(250);
      alert("jQuery click handler is active. Choose an event card to register.");
    });
  }
}

function initPortal() {
  document.querySelector("#eventInfo").textContent = eventInfo;

  addEvent(events, new Event(7, "Workshop on Gardening", "2026-07-05", 14, "Workshop", "River Park"));

  const musicTitles = filterEventsByCategory(events, "Music", (event) => event.name);
  const searchedEvents = filterEvents(events, (event) => event.location === "City Hall");

  console.log("Music titles:", musicTitles);
  console.log("City Hall events:", searchedEvents);

  renderEvents();
  populateEventOptions();
  showObjectAndArrayExamples();
  attachEventHandlers();
}

window.addEventListener("load", () => {
  alert("Page fully loaded");
});

document.addEventListener("DOMContentLoaded", initPortal);
