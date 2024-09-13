// add-student.js
document.getElementById('addStudentForm').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evita que el formulario se envíe de forma tradicional

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const age = document.getElementById('age').value;
    const phone = document.getElementById('phone').value;

    const student = {
        nameStudent: name,
        email: email,
        age: parseInt(age), // Asegúrate de que sea un número
        phone: phone
    };

    try {
        const response = await fetch('/api/registStudents', {
            method: 'POST', // Método para agregar datos
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(student) // Convierte el objeto a JSON
        });

        if (response.ok) {
            alert('Student added successfully!'); // Mensaje de éxito
            document.getElementById('addStudentForm').reset(); // Limpia el formulario
        } else {
            alert('Failed to add student: ' + response.statusText); // Mensaje de error
        }
    } catch (error) {
        console.error('Error adding student:', error);
        alert('Error adding student: ' + error.message);
    }
});
