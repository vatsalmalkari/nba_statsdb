const express = require('express');
const path = require('path');
const app = express();

// Middleware
app.use(express.urlencoded({ extended: true }));

// Set the correct path to your templates
const templatePath = path.join(__dirname, 'src', 'main', 'resources', 'templates');

// Serve static files if you have any in resources/static
app.use(express.static(path.join(__dirname, 'src', 'main', 'resources', 'static')));

// Login route
app.get('/login', (req, res) => {
    res.sendFile(path.join(templatePath, 'login.html'));
});

// Authentication endpoint
app.post('/authenticate', (req, res) => {
    // ... (keep your existing authentication logic)
});

const PORT = 8080;
app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}/login`);
});