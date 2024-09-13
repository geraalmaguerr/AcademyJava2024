// view-student.js
async function loadStudents() {
    try {
        const response = await fetch('/api/listStudents'); // Llama a tu endpoint
        const students = await response.json(); // Convierte la respuesta a JSON

        const table = document.getElementById('studentsTable');
        students.forEach(student => {
            const row = table.insertRow(); // Inserta una nueva fila
            const cellidStudent = row.insertCell(0);
            const cellnameStudent = row.insertCell(1);
            const cellemail = row.insertCell(2);
            const cellage = row.insertCell(3);
            const cellphone = row.insertCell(4);

            cellidStudent.textContent = student.idStudent;
            cellnameStudent.textContent = student.nameStudent;
            cellemail.textContent = student.email;
            cellage.textContent = student.age;
            cellphone.textContent = student.phone;
        });
    } catch (error) {
        console.error('Error fetching students:', error);
    }
}

window.onload = loadStudents; // Carga los estudiantes al cargar la página
