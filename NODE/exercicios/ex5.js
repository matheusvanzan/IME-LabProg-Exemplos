var students = [
    { name: "Alice", grades: [8, 9, 7] },
    { name: "Bob", grades: [5, 6, 5] },
    { name: "Charlie", grades: [9, 8, 10] },
    { name: "David", grades: [4, 5, 6] },
    { name: "Eve", grades: [7, 7, 8] }
];

function analyzeStudents(students) {
    // Step 1: Calculate the final grade for each student (average of grades)
    var studentsWithFinalGrades = students.map(student => ({
        name: student.name,
        finalGrade: student.grades.reduce((sum, grade) => sum + grade, 0) / student.grades.length
    }));

    // Step 2: Filter only approved students (finalGrade >= 7)
    var approvedStudents = studentsWithFinalGrades.filter(student => student.finalGrade >= 7);

    // Step 3: Calculate the overall average grade of all students
    var overallAverage = studentsWithFinalGrades.reduce((sum, student) => sum + student.finalGrade, 0) / studentsWithFinalGrades.length;

    // Step 4: Format the result
    return {
        approvedStudents: approvedStudents,
        overallAverage: parseFloat(overallAverage.toFixed(2)) // Rounding to 2 decimal places
    };
}

console.log(analyzeStudents(students));
