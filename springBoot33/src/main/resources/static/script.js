function confirmDelete(userId) {
    if (confirm("Вы уверены, что хотите удалить пользователя?")) {
        window.location.href = "/admin/delete/" + userId;
    }
}
