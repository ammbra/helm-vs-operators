import axios from 'axios';


export function getAllLandmarks() {
    const landmarkUrl = process.env.REACT_APP_LANDMARK_API_URL || "http://localhost:8080/api/landmark";
    console.log("landmarkUrl"+landmarkUrl);
    return axios.get(landmarkUrl);

}

export function getAllEvents() {
    const eventUrl = process.env.REACT_APP_EVENT_API_URL || "http://localhost:9090/api/event";
    console.log("eventUrl"+eventUrl);
    return axios.get(eventUrl);
}