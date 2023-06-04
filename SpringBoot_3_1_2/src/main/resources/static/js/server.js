function reloadTable() {
    fetch('http://localhost:8080/rest/admin/').then(
        response => {
            response.json().then(
                data => {
                    let temp = "";
                    data.forEach((u) => {
                        temp += "<tr >";
                        temp += "<td >" + u.id + "</td>";
                        temp += "<td >" + u.name + "</td>";
                        temp += "<td >" + u.password + "</td>";
                        temp += "<td >" + u.age + "</td>";
                        temp += "<td >" + u.email + "</td>";
                        temp += "<td >" + u.role + "</td>"
                        temp += "<td >" +
                            "<a class='btn btn-info' role='button' onmouseover='fillEditModal(" + u.id + ")' data-toggle='modal' data-target='#editUser'>Edit</a>" +
                            "<a class='btn btn-danger' role='button' onmouseover='fillDeleteModal(" + u.id + ")' data-toggle='modal' data-target='#deleteUser'>Delete</a>" +
                            "</td>"
                        temp += "</tr>";
                    })
                    // document.getElementById("list").innerHTML = temp;
                    $("#usersTableHere").empty();
                    $("#usersTableHere").append(temp);
                }
            )
        }
    )
}

function reloadPostTable() {
    fetch('http://localhost:8080/user/post/').then(
        response => {
            response.json().then(
                data => {
                    let temp = "";
                    data.forEach((p) => {
                        temp += "<tr >";
                        temp += "<td >" + p.id + "</td>";
                        temp += "<td >" + p.user.name + "</td>";
                        temp += "<td >" + p.title + "</td>";
                        temp += "<td >" + p.text + "</td>";
                        temp += "<td >" + p.dateCreate + "</td>";
                        temp += "<td >" +
                            // "<a class='btn btn-info' role='button' onmouseover='fillEditPostModal(" + p.id + ")' data-toggle='modal' data-target='#editPost'>Edit</a>" +
                            "<a class='btn btn-danger' role='button' onmouseover='fillDeletePostModal(" + p.id + ")' " +
                            "data-toggle='modal' data-target='#deletePost'>Delete</a>" +
                            "</td>"
                        temp += "</tr>";
                    })
                    // document.getElementById("list").innerHTML = temp;
                    $("#postTableHere").empty();
                    $("#postTableHere").append(temp);
                }
            )
        }
    )
}

function reloadProfileTable() {
    fetch('http://localhost:8080/user/post/profile/').then(
        response => {
            response.json().then(
                data => {
                    let temp = "";
                    data.forEach((p) => {
                        temp += "<tr >";
                        temp += "<td >" + p.id + "</td>";
                        temp += "<td >" + p.user.name + "</td>";
                        temp += "<td >" + p.title + "</td>";
                        temp += "<td >" + p.text + "</td>";
                        temp += "<td >" + p.dateCreate + "</td>";
                        temp += "<td >" +
                            "<a class='btn btn-info' role='button' onmouseover='fillEditPostModal(" + p.id + ")' data-toggle='modal' data-target='#editPost'>Edit</a>" +
                            "<a class='btn btn-danger' role='button' onmouseover='fillDeletePostModal(" + p.id + ")' " +
                            "data-toggle='modal' data-target='#deletePost'>Delete</a>" +
                            "</td>"
                        temp += "</tr>";
                    })
                    // document.getElementById("list").innerHTML = temp;
                    $("#profileTableHere").empty();
                    $("#profileTableHere").append(temp);
                }
            )
        }
    )
}

function fillEditModal(userId) {
    $.get("http://localhost:8080/rest/admin/" + userId, function (userJSON) {
        $('#idToEditUser').val(userJSON.id);
        $('#nameToEditUser').val(userJSON.name);
        $('#ageToEditUser').val(userJSON.age);
        $('#emailToEditUser').val(userJSON.email);
        $('#passwordToEditUser').val(userJSON.password);
        if (userJSON.role.length == 2) {
            $("#ROLE_USER").prop('checked', true);
            $("#ROLE_ADMIN").prop('checked', true);
        } else if (userJSON.role.length == 1 && userJSON.role[0] == "ROLE_USER") {
            $("#ROLE_USER").prop('checked', true);
            $("#ROLE_ADMIN").prop('checked', false);
        } else if (userJSON.role.length == 1) {
            $("#ROLE_USER").prop('checked', false);
            $("#ROLE_ADMIN").prop('checked', true);
        } else {
            $("#ROLE_USER").prop('checked', false);
            $("#ROLE_ADMIN").prop('checked', false);
        }
    });
}

function fillEditPostModal(postId) {
    $.get("http://localhost:8080/user/post/profile/" + postId, function (postJSON) {
        $('#idToEditPost').val(postJSON.id);
        $('#authorToEditPost').val(postJSON.user);
        $('#titleToEditPost').val(postJSON.title);
        $('#textToEditPost').val(postJSON.text);
        $('#dateToEditPost').val(postJSON.dateCreate);
    });
}

function fillDeleteModal(userId) {
    $.get("http://localhost:8080/rest/admin/" + userId, function (userJSON) {
        $('#idToDeleteUser').val(userJSON.id);
        $('#nameToDeleteUser').val(userJSON.name);
        $('#ageToDeleteUser').val(userJSON.age);
        $('#emailToDeleteUser').val(userJSON.email);
        // изменил, чтобы в окне удаления роли показывались текстом, вместо чекбоксов
        if (userJSON.role.length == 2) {
            $("#Delete_ROLE_USER").text("ROLE_USER");
            $("#Delete_ROLE_ADMIN").text("ROLE_ADMIN");
        } else if (userJSON.role.length == 1 && userJSON.role[0] == "ROLE_USER") {
            $("#Delete_ROLE_USER").text("ROLE_USER");
            $("#Delete_ROLE_ADMIN").text("");
        } else if (userJSON.role.length == 1) {
            $("#Delete_ROLE_USER").text("");
            $("#Delete_ROLE_ADMIN").text("ROLE_ADMIN");
        } else {
            $("#Delete_ROLE_USER").text("");
            $("#Delete_ROLE_ADMIN").text("");
        }
    });
}

function fillDeletePostModal(postId) {
    $.get("http://localhost:8080/user/post/" + postId, function (postJSON) {
        $('#idToDeletePost').val(postJSON.id);
        $('#authorToDeletePost').val(postJSON.user);
        $('#titleToDeletePost').val(postJSON.title);
        $('#textToDeletePost').val(postJSON.text);
        $('#dateToDeletePost').val(postJSON.dateCreate);
        // if (user.role.includes("ROLE_ADMIN")) {
        //     // Показывать кнопку "Edit" для администратора
        //     $("#editPostBtn").show();
        // } else {
        //     // Скрыть кнопку "Edit" для неадминистратора
        //     $("#editPostBtn").hide();
        // }
    });
}

function reloadNewUserTable() {
    $('#newName').val('');
    $('#newAge').val('');
    $('#newEmail').val('');
    $('#newPassword').val('');
    $("#New_ROLE_USER").prop('checked', false);
    $("#New_ROLE_ADMIN").prop('checked', false);
}

function reloadNewPostTable() {
    // $('#newAuthor').val();
    $('#newTitle').val('');
    $('#newText').val('');
    // $('#newDate').val('');
}

$(function () {
    $("#logout").append("<a class='custom-a' href='/logout'>Logout</a>");
    $('#addSubmit').on("click", function () {
        let checked = [];
        $('input:checkbox:checked').each(function () {
            checked.push($(this).val());
        });
        // reloadNewUserTable();

        let user = {
            name: $("#newName").val(),
            age: $("#newAge").val(),
            email: $("#newEmail").val(),
            password: $("#newPassword").val(),
            role: checked
        };
        let post = {
            user: $("#newAuthor").val(),
            text: $("#newText").val(),
            title: $("#newTitle").val(),
            dateCreate: $("#newDate").val()
        };
        fetch('http://localhost:8080/rest/admin/', {
            method: "POST",
            credentials: 'same-origin',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
            .then(() => {
                reloadTable();
                reloadNewUserTable();
            })
        fetch('http://localhost:8080/user/post/', {
            method: "POST",
            credentials: 'same-origin',
            body: JSON.stringify(post),
            headers: {
                'content-type': 'application/json'
            }
        })
            .then(() => {
                reloadTable();
                reloadPostTable();
                reloadProfileTable();
                reloadNewPostTable();
                reloadNewUserTable();
            })
    })

    $('#modalDeleteBtn').on("click", function () {
        fetch('http://localhost:8080/rest/admin/' + $('#idToDeleteUser').val(), {
            method: "DELETE",
            credentials: 'same-origin',
        })
            .then(() => {
                reloadTable();
            })
    });

    $('#modalDeletePostBtn').on("click", function () {
        fetch('http://localhost:8080/user/post/' + $('#idToDeletePost').val(), {
            method: "DELETE",
            credentials: 'same-origin',
        })
            .then(() => {
                reloadPostTable();
                reloadProfileTable();
            })
    });

    $('#modalEditBtn').on("click", function () {
        let checked = [];
        $('input:checkbox:checked').each(function () {
            checked.push($(this).val());
        });

        let user = {
            id: $('#idToEditUser').val(),
            name: $("#nameToEditUser").val(),
            age: $("#ageToEditUser").val(),
            email: $("#emailToEditUser").val(),
            password: $("#passwordToEditUser").val(),
            role: checked
        };
        fetch('http://localhost:8080/rest/admin/', {
            method: "PUT",
            credentials: 'same-origin',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
            // .then(() => {
            //     // Перенаправление пользователя на страницу /logout
            //     window.location.href = "/logout";
            // });
            .then(() => {
                reloadTable();
                reloadProfileTable();
                reloadNewUserTable();
            })
    });

    $('#modalEditPostBtn').on("click", function () {
        let checked = [];
        $('input:checkbox:checked').each(function () {
            checked.push($(this).val());
        });

        let post = {
            id: $('#idToEditPost').val(),
            user: $('#authorToEditPost').val(),
            title: $("#titleToEditPost").val(),
            text: $("#textToEditPost").val(),
            date: $("#dateToEditPost").val(),
        };
        fetch('http://localhost:8080/user/post/profile/', {
            method: "PUT",
            credentials: 'same-origin',
            body: JSON.stringify(post),
            headers: {
                'content-type': 'application/json'
            }
        })
            .then(() => {
                reloadPostTable()
                reloadProfileTable();
            })
    });
});
reloadTable();
reloadProfileTable()
reloadPostTable();
