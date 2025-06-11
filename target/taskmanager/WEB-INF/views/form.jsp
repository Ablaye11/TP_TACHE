<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <title>Formulaire Film</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">
<div class="container my-5">
    <h2 class="mb-4 text-center">${task.id == null ? "Ajouter un film" : "Modifier un film"}</h2>
    <form:form method="post" modelAttribute="task" action="${pageContext.request.contextPath}/tasks/save">
        <div class="mb-3">
            <label for="title" class="form-label">Titre *</label>
            <form:input path="title" cssClass="form-control" id="title" />
            <form:errors path="title" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <form:textarea path="description" cssClass="form-control" id="description" rows="3"/>
        </div>

        <div class="mb-3">
            <label for="priorite" class="form-label">Priorité *</label>
            <form:select path="priorite" cssClass="form-select" id="priorite">
                <form:option value="URGENTE" label="URGENTE" />
                <form:option value="NORMALE" label="NORMALE" />
                <form:option value="FAIBLE" label="FAIBLE" />
            </form:select>
            <form:errors path="priorite" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="status" class="form-label">Statut</label>
            <form:select path="status" cssClass="form-select" id="status">
                <form:option value="A_REGARDER" label="À regarder" />
                <form:option value="EN_COURS" label="En cours" />
                <form:option value="TERMINEE" label="Terminée" />
            </form:select>
        </div>

        <div class="mb-3">
            <label for="dueDate" class="form-label">Date limite</label>
            <form:input path="dueDate" cssClass="form-control" id="dueDate" type="date" />
        </div>

        <button type="submit" class="btn btn-primary">${task.id == null ? "Ajouter" : "Modifier"}</button>
        <a href="${pageContext.request.contextPath}/tasks" class="btn btn-secondary">Annuler</a>
    </form:form>
</div>
</body>
</html>
