document.getElementById('registerForm').addEventListener('submit', async function(e) {
    e.preventDefault();

    const lastName = document.getElementById('lastName').value;
    const firstName = document.getElementById('firstName').value;
    const role = document.getElementById('role').value;
    const dob = document.getElementById('dob').value;
    const email = document.getElementById('email').value;
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const address = document.getElementById('address').value;
    const city = document.getElementById('city').value;
    const stateCode = document.getElementById('stateCode').value;
    const zip = document.getElementById('zip').value;
    const phone = document.getElementById('phone').value;

    const response = await fetch('api/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ lastName, firstName, role, dob, email, username, password, address, city, stateCode, zip, phone })
    });

    const data = await response.json();
    alert(data.message);
});


