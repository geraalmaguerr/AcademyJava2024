// delete-student.js
document.getElementById('deleteStudentForm').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evita que el formulario se envíe de forma tradicional

    const id = document.getElementById('id').value;

    try {
        const response = await fetch(`/api/deleteStudent/${id}`, {
            method: 'DELETE', // Método para eliminar datos
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (response.ok) {
            alert('Student deleted successfully!'); // Mensaje de éxito
            document.getElementById('deleteStudentForm').reset(); // Limpia el formulario
        } else {
            alert('Failed to delete student: ' + response.statusText); // Mensaje de error
        }
    } catch (error) {
        console.error('Error deleting student:', error);
        alert('Error deleting student: ' + error.message);
    }
});
