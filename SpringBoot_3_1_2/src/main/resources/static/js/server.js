function fillTable(url, tableHere, tableOf, callback) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            let temp = "";
            if (tableOf === 'posts') {
                data.forEach(p => {
                    temp += "<tr>";
                    temp += "<td>" + p.id + "</td>";
                    temp += "<td>" + p.user.name + "</td>";
                    temp += "<td>" + p.title + "</td>";
                    temp += "<td>" + p.text + "</td>";
                    temp += "<td>" + p.dateCreate + "</td>";
                    if (callback !== null)
                        temp += "<td>" + callback(p.id) + "</td>";
                    temp += "</tr>";
                });
            } else if (tableOf === 'users') {
                data.forEach(u => {
                    temp += "<tr >";
                    temp += "<td >" + u.id + "</td>";
                    temp += "<td >" + u.name + "</td>";
                    temp += "<td >" + u.age + "</td>";
                    temp += "<td >" + u.email + "</td>";
                    temp += "<td >" + u.password + "</td>";
                    temp += "<td >" + u.role + "</td>"
                    temp += "<td >" + callback(u.id) + "</td>"
                    temp += "</tr>";
                });
            }
            $(tableHere).empty().append(temp);
        })

}

function reloadUserTable() {
    const url = 'http://localhost:8080/admin/';
    const tableHere = '#usersTableHere';

    fillTable(url, tableHere, 'users', (userId) => {
        return "<a class='btn btn-info' role='button' onmouseover='fillEditUserModal(" + userId + ")'" +
            " data-toggle='modal' data-target='#editUser'>Изменить ✏️</a>" +
            "<a class='btn btn-danger' role='button' onmouseover='fillDeleteUserModal(" + userId + ")' " +
            "data-toggle='modal' data-target='#deleteUser'>Удалить ❌</a>";
    });
}

function reloadPostTableAdmRole() {
    const url = 'http://localhost:8080/admin/post/';
    const tableHere = '#postTableForAdmHere';

    fillTable(url, tableHere, 'posts', (postId) => {
        return "<a class='btn btn-danger' role='button' onmouseover='fillDeletePostModalAdmRole(" + postId + ")' " +
            "data-toggle='modal' data-target='#deletePost'>Удалить ❌</a>";
    });
}

function reloadPostTableUsrRole() {
    const url = 'http://localhost:8080/user/post/all/';
    const tableHere = '#postTableForUsrHere';

    fillTable(url, tableHere, 'posts', null)
}

function reloadPostTableOfUser() {
    const url = 'http://localhost:8080/user/post/';
    const tableHere = '#profileTableHere';

    fillTable(url, tableHere, 'posts', (postId) => {
        return "<a class='btn btn-info' role='button' onmouseover='fillEditPostModal(" + postId + ")'" +
            " data-toggle='modal' data-target='#editPost'>Изменить ✏️</a>" +
            "<a class='btn btn-danger' role='button' onmouseover='fillDeletePostModalUsrRole(" + postId + ")' " +
            "data-toggle='modal' data-target='#deleteMyPost'>Удалить ❌</a>";
    });
}

function fillEditUserModal(userId) {
    $.get("http://localhost:8080/admin/" + userId, function (userJSON) {
        $('#idToEditUser').val(userJSON.id);
        $('#nameToEditUser').val(userJSON.name);
        $('#ageToEditUser').val(userJSON.age);
        $('#emailToEditUser').val(userJSON.email);
        $('#passwordToEditUser').val(userJSON.password);

        if (userJSON.role.length === 2) {
            $("#ROLE_USER").prop('checked', true);
            $("#ROLE_ADMIN").prop('checked', true);
        } else if (userJSON.role.includes("ROLE_USER")) {
            $("#ROLE_USER").prop('checked', true);
            $("#ROLE_ADMIN").prop('checked', false);
        } else if (userJSON.role.includes("ROLE_ADMIN")) {
            $("#ROLE_USER").prop('checked', false);
            $("#ROLE_ADMIN").prop('checked', true);
        } else {
            $("#ROLE_USER").prop('checked', false);
            $("#ROLE_ADMIN").prop('checked', false);
        }
    });
}

function fillEditPostModal(postId) {
    $.get("http://localhost:8080/user/post/" + postId, function (postJSON) {
        $('#idToEditPost').val(postJSON.id);
        $('#authorToEditPost').val(postJSON.user);
        $('#titleToEditPost').val(postJSON.title);
        $('#textToEditPost').val(postJSON.text);
        $('#dateToEditPost').val(postJSON.dateCreate);
    });
}

function fillDeleteUserModal(userId) {
    $.get("http://localhost:8080/admin/" + userId, function (userJSON) {
        $('#idToDeleteUser').val(userJSON.id);
        $('#nameToDeleteUser').val(userJSON.name);
        $('#ageToDeleteUser').val(userJSON.age);
        $('#emailToDeleteUser').val(userJSON.email);

        if (userJSON.role.length === 2) {
            $("#Delete_ROLE_USER").text("ROLE_USER");
            $("#Delete_ROLE_ADMIN").text("ROLE_ADMIN");
        } else if (userJSON.role.includes("ROLE_USER")) {
            $("#Delete_ROLE_USER").text("ROLE_USER");
            $("#Delete_ROLE_ADMIN").text("");
        } else if (userJSON.role.includes("ROLE_ADMIN")) {
            $("#Delete_ROLE_USER").text("");
            $("#Delete_ROLE_ADMIN").text("ROLE_ADMIN");
        } else {
            $("#Delete_ROLE_USER").text("");
            $("#Delete_ROLE_ADMIN").text("");
        }
    });
}

function fillDeletePostModalAdmRole(postId) {
    $.get("http://localhost:8080/admin/post/" + postId, function (postJSON) {
        $('#idToDeletePost').val(postJSON.id);
        $('#authorToDeletePost').val(postJSON.user.name);
        $('#titleToDeletePost').val(postJSON.title);
        $('#textToDeletePost').val(postJSON.text);
        $('#dateToDeletePost').val(postJSON.dateCreate);
    });
}

function fillDeletePostModalUsrRole(postId) {
    $.get("http://localhost:8080/user/post/" + postId, function (postJSON) {
        $('#idToDeleteMyPost').val(postJSON.id);
        $('#authorToDeleteMyPost').val(postJSON.user.name);
        $('#titleToDeleteMyPost').val(postJSON.title);
        $('#textToDeleteMyPost').val(postJSON.text);
        $('#dateToDeleteMyPost').val(postJSON.dateCreate);
    });
}

function reloadNewUserForm() {
    $('#newName').val('');
    $('#newAge').val('');
    $('#newEmail').val('');
    $('#newPassword').val('');
    $("#New_ROLE_USER").prop('checked', false);
    $("#New_ROLE_ADMIN").prop('checked', false);
}

function reloadNewPostForm() {
    $('#newTitle').val('');
    $('#newText').val('');
}

$(function () {
    $("#logout").append("<a class='custom-a' href='/logout'>Logout</a>");
    $('#addSubmit').on("click", function () {
        let checked = [];
        $('input:checkbox:checked').each(function () {
            checked.push($(this).val());
        });

        let user = {
            name: $("#newName").val(),
            age: $("#newAge").val(),
            email: $("#newEmail").val(),
            password: $("#newPassword").val(),
            role: checked
        };

        fetch('http://localhost:8080/admin', {
            method: "POST",
            credentials: 'same-origin',
            body: JSON.stringify(user),
            headers: {'content-type': 'application/json'}
        }).then(() => {
            reloadUserTable();
            reloadNewUserForm();
            reloadUserTable();
        })
    })

    $('#addPostSubmit').on("click", function () {
        let checked = [];
        $('input:checkbox:checked').each(function () {
            checked.push($(this).val());
        });

        let myPost = {
            text: $("#newText").val(),
            title: $("#newTitle").val()
        };

        fetch('http://localhost:8080/user/post', {
            method: "POST",
            credentials: 'same-origin',
            body: JSON.stringify(myPost),
            headers: {'content-type': 'application/json'}
        }).then(() => {
            reloadPostTableOfUser();
            reloadNewPostForm();
            reloadPostTableOfUser()
        })
    })

    $('#modalDeleteBtn').on("click", function () {
        fetch('http://localhost:8080/admin/' + $('#idToDeleteUser').val(), {
            method: "DELETE",
            credentials: 'same-origin',
        }).then(() => {
            reloadUserTable();
            reloadPostTableAdmRole()
        })
    });

    $('#modalDeletePostBtn').on("click", function () {
        fetch('http://localhost:8080/admin/post/' + $('#idToDeletePost').val(), {
            method: "DELETE",
            credentials: 'same-origin',
        }).then(() => reloadPostTableAdmRole())
    });

    $('#modalDeleteMyPostBtn').on("click", function () {
        fetch('http://localhost:8080/user/post/' + $('#idToDeleteMyPost').val(), {
            method: "DELETE",
            credentials: 'same-origin',
        }).then(() => {
            reloadPostTableOfUser();
            reloadPostTableUsrRole()
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

        fetch('http://localhost:8080/admin/', {
            method: "PUT",
            credentials: 'same-origin',
            body: JSON.stringify(user),
            headers: {'content-type': 'application/json'}
        }).then(() => {
            reloadUserTable();
            reloadPostTableOfUser();
        })
    });

    $('#modalEditPostBtn').on("click", function () {
        let checked = [];
        $('input:checkbox:checked').each(function () {
                checked.push($(this).val());
            }
        );

        let post = {
            id: $('#idToEditPost').val(),
            title: $("#titleToEditPost").val(),
            text: $("#textToEditPost").val(),
        };

        fetch('http://localhost:8080/user/post/', {
            method: "PUT",
            credentials: 'same-origin',
            body: JSON.stringify(post),
            headers: {'content-type': 'application/json'}
        }).then(() => {
            reloadPostTableOfUser();
            reloadPostTableUsrRole();
        })
    });
});
reloadUserTable();
reloadPostTableOfUser()
reloadPostTableAdmRole();
reloadPostTableUsrRole()
