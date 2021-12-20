package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.*;
import com.abi.cinema.db.entity.*;
import com.abi.cinema.servlet.view.FilmPageItem;
import com.abi.cinema.servlet.view.SeancePage;
import com.abi.cinema.servlet.view.SeancePageItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UtilsForServlets {


    public static String validFilm(Film film, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textError = "";
        if (film.getTitle().equals("") | film.getYear().equals("")) {
            textError = "Не заполнено обязательное поле";
        } else {
            if (film.getId() == null) {
                if (FilmDAO.getFilmByContent(film).size() != 0) {
                    textError = "Фильм с таким названием уже есть";
                }
            } else {
                List<Item> filter = new ArrayList<>();
                filter.add(new Item("", "title", "=", film.getTitle()));
                filter.add(new Item("AND", "id", "!=", film.getId()));
                if (FilmDAO.getFilmByFilter(filter).size() != 0) {
                    textError = "Фильм с таким названием уже есть";
                }
            }
        }
        return textError;
    }

    /**
     *  Utils for films
     */
    public static void listFilm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Film> listFilm = FilmDAO.getAllFilm();
        List<FilmPageItem> listFilePageItem = new ArrayList<>();
        for (Film film : listFilm) {
            List<Genre> listGenre = FilmGenreDAO.getFilmGenreByFilmId(film.getId());
            listFilePageItem.add(new FilmPageItem(film, listGenre));
        }
        session.setAttribute("listFilePageItem", listFilePageItem);
        resp.sendRedirect("listfilm.jsp");
    }

    /**
     * Utils for genres
     */

    public static String validGenre(Genre genre, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textError = "inall.errorfree";
        if (genre.getName().equals("")) {
            textError = "inall.Requiredfieldisnotfilled";
        } else {
            if (genre.getId() == null) {
                if (GenreDAO.getGenreByContent(genre).size() != 0) {
                    textError = "Такой жанр уже существует";
                }
            } else {
                List<Item> filter = new ArrayList<>();
                filter.add(new Item("", "name", "=", genre.getName()));
                filter.add(new Item("AND", "id", "!=", genre.getId()));
                if (GenreDAO.getGenreByFilter(filter).size() != 0) {
                    textError = "Такой жанр уже существует";
                }
            }
        }
        return textError;
    }

    public static void listGenre(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Genre> genre = GenreDAO.getAllGenre();
        session.setAttribute("genre", genre);
        resp.sendRedirect("listgenre.jsp");
    }

    /**
     * Utils for users
     */

    public static String validUser(User user, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textError = "inall.errorfree";
        if (user.getEmail().equals("") | user.getPassword().equals("")) {
            textError = "inall.Requiredfieldisnotfilled";
        } else {
            if (user.getId() == null) {
                if (UserDAO.getUserByContent(user).size() != 0) {
                    textError = "user.ThereisalreadyauserwiththisE-mail";
                }
            } else {
                List<Item> filter = new ArrayList<>();
                filter.add(new Item("", "email", "=", user.getEmail()));
                filter.add(new Item("AND", "id", "!=", user.getId()));
                if (UserDAO.getUserByFilter(filter).size() != 0) {
                    textError = "user.ThereisalreadyauserwiththisE-mail";
                }
            }
            if (!user.getPassword().equals(req.getParameter("password1"))) {
                textError = "user.Passwordmismatch";
            }
        }
        return textError;
    }

    public static String validLoginUser(User user, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textError = "inall.errorfree";
        if (user.getEmail().equals("") | user.getPassword().equals("")) {
            textError = "inall.Requiredfieldisnotfilled";
        } else {
            List<Item> filter = new ArrayList<>();
            filter.add(new Item("", "email", "=", user.getEmail()));
            filter.add(new Item("AND", "password", "=", user.getPassword()));
            List<User> listUser = UserDAO.getUserByFilter(filter);
            if (listUser.size() == 0) {
                textError = "user.Userisnotfound";
            } else {
                if (listUser.size() > 1) {
                    textError = "user.Thereareseveralsuchusers";
                }
            }
        }
        return textError;
    }

    public static void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<User> user = UserDAO.getAllUser();
        session.setAttribute("user", user);
        resp.sendRedirect("listuser.jsp");
    }

    public static String validSeance(Seance insertSeance, HttpServletRequest req, HttpServletResponse resp) {
        return "";
    }

    public static void listSeance(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SeancePage seancePage = (SeancePage) session.getAttribute("seancePage");
        if (seancePage == null) {
            seancePage = new SeancePage();
        }
        seancePage.setAllSeance(SeanceDAO.getAllSeance().size());
        String sortField = req.getParameter("seanceSort");
        if (sortField != null) {
            if (seancePage.getPageSort() != sortField) {
                seancePage.setPageNumber(1);
            }
            seancePage.setPageSort(sortField);
        }
        String newPage =req.getParameter("newPage");
        if (newPage != null) {
            seancePage.setPageNumber(Integer.parseInt(newPage));
        }
        String newPageSize =req.getParameter("newPageSize");
        if (newPageSize != null) {
            seancePage.setPageSize(Integer.parseInt(newPageSize));
        }
        String newGenreIdFilter =req.getParameter("newGenreIdFilter");
        if (newGenreIdFilter != null) {
            seancePage.setGenreIdFilter(Integer.parseInt(newGenreIdFilter));
        }

        String newFilmIdFilter =req.getParameter("newFilmIdFilter");
        if (newFilmIdFilter != null) {
            seancePage.setFilmIdFilter(Integer.parseInt(newFilmIdFilter));
        }

        List<Item> seanceFilter = new ArrayList<>();
        User currentUser = (User) session.getAttribute("currentUser");
        if ((currentUser != null && currentUser.getRole() == 0) || currentUser == null) {
            seanceFilter.add(new Item("", "seance.dateTime", ">",
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        }
        if (seancePage.getGenreIdFilter() > 0) {
            seanceFilter.add(new Item(seanceFilter.size() == 0 ? "" : "AND",
                    "film_genre.genreId", "=", "" + seancePage.getGenreIdFilter()));
        }
        if (seancePage.getFilmIdFilter() > 0) {
            seanceFilter.add(new Item(seanceFilter.size() == 0 ? "" : "AND",
                    "film.Id", "=", "" + seancePage.getFilmIdFilter()));
        }

        String joinCondition = "";
        String postCondition = "";
        if (seancePage.getGenreIdFilter() > 0) {
            joinCondition = " INNER JOIN film ON seance.filmId=film.id INNER JOIN film_genre ON film.id=film_genre.filmId ";
        } else {
            if (seancePage.getFilmIdFilter() > 0 || seancePage.getPageSort().equals("filmId, dateTime")) {
                joinCondition = " INNER JOIN film ON seance.filmId=film.id ";
            }
        }
        List<Seance> seanceFiltered = SeanceDAO.getSeanceBySQL(joinCondition, seanceFilter, postCondition);
        seancePage.setAllSeance(seanceFiltered.size());
        int offset = (int) ((seancePage.getPageNumber() - 1) * seancePage.getPageSize());
        if (offset < 0){
            offset = 0;
        }
        if (seancePage.getPageSort().equals("freeSeat")) {
            joinCondition = " INNER JOIN ticket ON seance.id=ticket.seanceId " + joinCondition;
        }

        if (seancePage.getPageSort().equals("freeSeat")) {
            postCondition = " GROUP BY seance.id ORDER BY COUNT(ticket.id)";
        } else {
            if (seancePage.getPageSort().equals("filmId, dateTime")) {
                postCondition = " ORDER BY film.title, seance.dateTime";
            } else {
                postCondition = " ORDER BY " + seancePage.getPageSort();
            }
        }
        postCondition = postCondition + " LIMIT " + offset + ", " + seancePage.getPageSize();

        seanceFiltered = SeanceDAO.getSeanceBySQL(joinCondition, seanceFilter, postCondition);
        seancePage.setPageMax((int)Math.ceil((0.0 + seancePage.getAllSeance()) / seancePage.getPageSize()));
        if (seancePage.getPageMax() < seancePage.getPageNumber()) {
            seancePage.setPageNumber(seancePage.getPageMax());
        }
        seancePage.getListGenre().clear();
        seancePage.setListGenre(GenreDAO.getAllGenre());
        seancePage.getListFilm().clear();
        seancePage.setListFilm(FilmDAO.getAllFilm());
        session.setAttribute("seancePage", seancePage);

        List<SeancePageItem> seanceList = new ArrayList<>();
        for (Seance seance : seanceFiltered ) {
            Film film = FilmDAO.getFilmById(seance.getFilmId());
            List<Item> filter = new ArrayList<>();
            filter.add(new Item("", "seanceId", "=", seance.getId() ));
            Date nowDateTime = new Date();
            seanceList.add( new SeancePageItem(seance.getId(),
                                    new SimpleDateFormat("dd.MM.yyyy HH:mm").format(seance.getDateTime()),
                                    film.getTitle(),
                                    film.getPhotoURL(),
                                    FilmGenreDAO.getFilmGenreByFilmId(film.getId()),
                                    SeatDAO.MAX_LINE * SeatDAO.MAX_POSITION - TicketDAO.getTicketByFilter(filter).size(),
                                    seance.getBaseCost(),
                                    seance.getDateTime().after(nowDateTime)));
        }
        session.setAttribute("seanceList", seanceList);
        req.getRequestDispatcher("listseance.jsp").forward(req, resp);
    }

    public static void fillFreeHall(HttpServletRequest req) throws IOException {
        System.out.println("fillFreeHall");

        HttpSession session = req.getSession();

        session.setAttribute("maxLine", SeatDAO.MAX_LINE - 1);
        session.setAttribute("maxPosition", SeatDAO.MAX_POSITION - 1);

        Integer[][] hall = (Integer[][]) session.getAttribute("hall");
        if (hall == null) {
            hall = new Integer[SeatDAO.MAX_LINE][SeatDAO.MAX_POSITION];
        }
        for (int i = 0; i < SeatDAO.MAX_LINE; i++) {
            for (int j = 0; j < SeatDAO.MAX_POSITION; j++) {
                hall[i][j] = 0;
            }
        }
        session.setAttribute("hall", hall);

        Integer[][] hallId = (Integer[][]) session.getAttribute("hallId");
        if (hallId == null) {
            hallId = new Integer[SeatDAO.MAX_LINE][SeatDAO.MAX_POSITION];
        }
        for (int i = 0; i < SeatDAO.MAX_LINE; i++) {
            for (int j = 0; j < SeatDAO.MAX_POSITION; j++) {
                hallId[i][j] = -1;
            }
        }
        for (Seat s : SeatDAO.getAllSeat()) {
            hallId[s.getLine()-1][s.getPosition()-1] = s.getId();
        }
        session.setAttribute("hallId", hallId);
    }

    public static void fillSeatInHall(HttpServletRequest req) throws IOException {
        System.out.println("fillSeatInHall");

        fillFreeHall(req);

        HttpSession session = req.getSession();

        Seance buySeance = (Seance) session.getAttribute("buySeance");
        Integer[][] hall = (Integer[][]) session.getAttribute("hall");

        List<Ticket> listBaseTicket = TicketDAO.getTicketBySeance(buySeance);
        for (Ticket t : listBaseTicket) {
            Seat seat = SeatDAO.getSeatById(t.getSeatId());
            hall[seat.getLine()-1][seat.getPosition()-1] = 1;
        }

        List<Seat> reservedSeat =  new ArrayList<Seat>();
        User currentUser = (User) session.getAttribute("currentUser");
        List<Ticket> listPoolTicket = ReservePool.getTicketBySeance(buySeance);
        for (Ticket t : listPoolTicket) {
            Seat seat = SeatDAO.getSeatById(t.getSeatId());
            if (t.getUserId().equals(currentUser.getId())) {
                hall[seat.getLine()-1][seat.getPosition()-1] = 2;
                reservedSeat.add(seat);
            } else {
                hall[seat.getLine()-1][seat.getPosition()-1] = 3;
            }
        }

        session.setAttribute("hall", hall);
        session.setAttribute("reservedSeat", reservedSeat);

        int freeSeat = SeatDAO.MAX_LINE * SeatDAO.MAX_POSITION - listBaseTicket.size() -listPoolTicket.size();
        session.setAttribute("freeSeat", freeSeat);
    }

}


