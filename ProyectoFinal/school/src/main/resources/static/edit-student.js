document.getElementById('editStudentForm').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evita que el formulario se envíe de forma tradicional

    // Obtener los valores del formulario
    const id = document.getElementById('studentId').value; // ID del estudiante
    const studentData = {
        nameStudent: document.getElementById('name').value,
        email: document.getElementById('email').value,
        age: parseInt(document.getElementById('age').value), // Asegúrate de que sea un número
        phone: document.getElementById('phone').value
    };

    try {
        const response = await fetch(`/api/updateStudent/${id}`, {
            method: 'PUT', // Método para actualizar
            headers: {
                'Content-Type': 'application/json' // Indica que se envía JSON
            },
            body: JSON.stringify(studentData) // Convierte el objeto a formato JSON
        });

        if (response.ok) {
            const updatedStudent = await response.json(); // Obtiene la respuesta JSON
            alert(`Student updated successfully: ${JSON.stringify(updatedStudent)}`); // Mensaje de éxito
            window.location.href = 'index.html'; // Redirigir a la lista de estudiantes
        } else {
            alert('Failed to update student: ' + response.statusText); // Mensaje de error
        }
    } catch (error) {
        console.error('Error updating student:', error);
        alert('Error updating student: ' + error.message);
    }
});
