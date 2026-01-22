const beepSound = document.getElementById('beepAudio');
const loginForm = document.getElementById('attendanceForm');
const loginCard = document.getElementById('loginCard');
const passwordField = document.getElementById('password');
const togglePass = document.getElementById('togglePass');
const timestampArea = document.getElementById('timestampArea');
const displayTime = document.getElementById('displayTime');
const downloadBtn = document.getElementById('downloadBtn');

let currentUsername = "";
let currentTimestamp = "";

togglePass.addEventListener('click', function() {
    const isPassword = passwordField.getAttribute('type') === 'password';
    passwordField.setAttribute('type', isPassword ? 'text' : 'password');
    this.classList.toggle('fa-eye-slash');
});

loginForm.addEventListener('submit', function(e) {
    e.preventDefault();
    
    const email = document.getElementById('email').value.trim();
    const password = passwordField.value.trim();
    const passError = document.getElementById('passwordError');

    passError.innerText = '';
    loginCard.style.borderColor = 'rgba(255, 204, 0, 0.2)';

    if (email === 'SiegfridFranklin@gmail.com' && password === 'gamedev123') {
        currentUsername = email;
        const now = new Date();
        currentTimestamp = now.toLocaleString();

        loginForm.style.display = 'none';
        timestampArea.style.display = 'block';
        displayTime.innerText = "Logged at: " + currentTimestamp;
    } else {

        beepSound.currentTime = 0; 
        beepSound.play().catch(err => console.log("Interaction needed for audio"));

        passError.innerText = "Invalid credentials. Access Denied.";
        loginCard.style.borderColor = 'var(--red)';
    }
});

downloadBtn.addEventListener('click', function() {
    const data = `ATTENDANCE SUMMARY\nUser: ${currentUsername}\nTimestamp: ${currentTimestamp}\nStatus: Verified`;
    const blob = new Blob([data], { type: 'text/plain' });
    const url = window.URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `Attendance_${currentUsername.split('@')[0]}.txt`;
    a.click();
});