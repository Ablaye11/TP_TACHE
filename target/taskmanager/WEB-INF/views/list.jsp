<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <title>Liste des films à regarder</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">
<div class="container my-5">
    <h2 class="mb-4 text-center">Gestionnaire de Films à Regarder</h2>
    <div class="text-end mb-3">
        <a href="${pageContext.request.contextPath}/tasks/add" class="btn btn-success">Ajouter un film</a>
    </div>

    <table class="table table-striped table-bordered align-middle">
        <thead class="table-dark">
        <tr>
            <th>Titre</th>
            <th>Description</th>
            <th>Priorité</th>
            <th>Statut</th>
            <th>Date limite</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td>${task.title}</td>
                <td><c:out value="${task.description}" default="-" /></td>
                <td>
                    <span class="badge
                        ${task.priorite == 'URGENTE' ? 'bg-danger' :
                          task.priorite == 'NORMALE' ? 'bg-primary' : 'bg-secondary'}">
                            ${task.priorite}
                    </span>
                </td>
                <td>
                    <span class="badge
                        ${task.status == 'A_REGARDER' ? 'bg-warning' :
                          task.status == 'EN_COURS' ? 'bg-info' : 'bg-success'}">
                            ${task.status.replace('_', ' ')}
                    </span>
                </td>
                <td><c:out value="${task.dueDate}" default="Non précisée"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/tasks/status/${task.id}"
                       class="btn btn-sm btn-warning">Changer statut</a>
                    <a href="${pageContext.request.contextPath}/tasks/edit/${task.id}"
                       class="btn btn-sm btn-primary">Modifier</a>
                    <a href="${pageContext.request.contextPath}/tasks/delete/${task.id}"
                       onclick="return confirm('Voulez-vous vraiment supprimer ce film ?');"
                       class="btn btn-sm btn-danger">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
