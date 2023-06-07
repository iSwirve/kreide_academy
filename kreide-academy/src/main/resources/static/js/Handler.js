$(document).ready(function (){
    const date = new Date();
    const currentYear = date.getFullYear();
    const currentMonth = date.getMonth() + 1; // 👈️ months are 0-based

// 👇️ Current Month
    const daysInCurrentMonth = getDaysInMonth(currentYear, currentMonth);
    console.log(daysInCurrentMonth); // 👉️ 31
    for (var i = 0; i < daysInCurrentMonth; i++)
    {
        $(".calendarAbsensi").append("<div>aa</div>");
    }

})