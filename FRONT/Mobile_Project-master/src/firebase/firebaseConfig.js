// Import the functions you need from the SDKs you need
import { initializeApp } from 'firebase/app';
import { getStorage } from 'firebase/storage';
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
    const firebaseConfig = {
    apiKey: "AIzaSyDYUbXyXrRjWEzCfFYRATxWIEoVU4JdHeE",
    authDomain: "enset-store.firebaseapp.com",
    projectId: "enset-store",
    storageBucket: "enset-store.appspot.com",
    messagingSenderId: "913533907830",
    appId: "1:913533907830:web:5e56ad9ff50c48db71c057",
    measurementId: "G-ZHYPFX8TQ5"
    };

    const app = initializeApp(firebaseConfig);

    // Get a reference to the storage service
    const storage = getStorage(app);
    
    export { storage };