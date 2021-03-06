
<header style="max-width: 1200px">
    <div style="display: flex; justify-content: center">
        <div style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center">
            <div style="width: 140px; height: 105px; background-image: url(./img/cinema.jpg); background-size: 140px;
                        box-shadow: 0 0 15px 15px #f0dbc2 inset"> </div>
        </div>

        <div align="center" style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center;
                    text-decoration: none; color: white; font-size: 24px; font-weight: bold;
                    text-shadow: 5px 0 5px #640c0c, 0 5px 5px #640c0c, -5px 0 5px #640c0c, 0 -5px 5px #640c0c,
                                 5px 5px 5px #640c0c, -5px 5px 5px #640c0c, -5px -5px 5px #640c0c, 5px -5px 5px #640c0c">
            <a href="/cin" style="text-decoration: none; color: white"><fmt:message key="mainheader.Main"/><br><fmt:message key="mainheader.Page"/></a>
        </div>

        <div align="center" style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center;
                    text-decoration: none; color: white; font-size: 24px; font-weight: bold;
                    text-shadow: 5px 0 5px #640c0c, 0 5px 5px #640c0c, -5px 0 5px #640c0c, 0 -5px 5px #640c0c,
                                 5px 5px 5px #640c0c, -5px 5px 5px #640c0c, -5px -5px 5px #640c0c, 5px -5px 5px #640c0c">
            <a href="/cin/listSeance" style="text-decoration: none; color: white"><fmt:message key="mainheader.Seance"/><br><fmt:message key="mainheader.Schedule"/></a>
        </div>

        <div align="center" style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center;
                    color: white; font-size: 24px; font-weight: bold;
                    text-shadow: 5px 0 5px #640c0c, 0 5px 5px #640c0c, -5px 0 5px #640c0c, 0 -5px 5px #640c0c,
                                 5px 5px 5px #640c0c, -5px 5px 5px #640c0c, -5px -5px 5px #640c0c, 5px -5px 5px #640c0c">
            <c:if test="${currentUser == null}">
                <fmt:message key="mainheader.Unknown"/><br><fmt:message key="mainheader.user"/>
            </c:if>
            <c:if test="${currentUser != null}">
                <c:if test="${currentUser.role == 0}">
                    <fmt:message key="mainheader.Current"/><br><fmt:message key="mainheader.user"/>:
                </c:if>
                <c:if test="${currentUser.role == 1}">
                    <fmt:message key="mainheader.Current"/><br><fmt:message key="mainheader.admin"/>:
                </c:if>
            </c:if>
        </div>

        <div align="center" style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center;
                    color: white; font-size: 24px; font-weight: bold;
                    text-shadow: 5px 0 5px #640c0c, 0 5px 5px #640c0c, -5px 0 5px #640c0c, 0 -5px 5px #640c0c,
                                 5px 5px 5px #640c0c, -5px 5px 5px #640c0c, -5px -5px 5px #640c0c, 5px -5px 5px #640c0c">
            <c:if test="${currentUser == null}">
                <a href="/cin/formLoginUser" style="text-decoration: none; color: white"><fmt:message key="mainheader.Login"/></a>
            </c:if>
            <c:if test="${currentUser != null}">
                ${currentUser.name}<br>${currentUser.surname}
            </c:if>
        </div>

        <div align="center" style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center;
                    text-decoration: none; color: white; font-size: 24px; font-weight: bold;
                    text-shadow: 5px 0 5px #640c0c, 0 5px 5px #640c0c, -5px 0 5px #640c0c, 0 -5px 5px #640c0c,
                                 5px 5px 5px #640c0c, -5px 5px 5px #640c0c, -5px -5px 5px #640c0c, 5px -5px 5px #640c0c">
            <c:if test="${currentUser == null}">
                <a href="/cin/formRegisterUser" style="text-decoration: none; color: white"><fmt:message key="mainheader.Register"/></a>
            </c:if>
            <c:if test="${currentUser != null}">
                <a href="/cin/logoutUser" style="text-decoration: none; color: white"><fmt:message key="mainheader.Logout"/></a>
            </c:if>
        </div>

        <div style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    ">
            <div style="margin: 5px;
                    display: flex; justify-content: flex-end;
                    text-decoration: none; color: white; font-size: 18px; font-weight: bold;
                    text-shadow: 5px 0 5px #640c0c, 0 5px 5px #640c0c, -5px 0 5px #640c0c, 0 -5px 5px #640c0c,
                                 5px 5px 5px #640c0c, -5px 5px 5px #640c0c, -5px -5px 5px #640c0c, 5px -5px 5px #640c0c">
                <a href="/cin/changeLocale.jsp" style="color: white">En/Ru</a>
            </div>
            <div style="margin-top: 10px; display: flex; justify-content: center">
                <a href="/cin/bascket"><img src="./img/basket.png" style="width: 130px; box-shadow: 0px 0px 10px 5px #ffffff"></a>
            </div>
        </div>
    </div>
</header>
