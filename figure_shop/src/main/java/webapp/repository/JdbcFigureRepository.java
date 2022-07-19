//package webapp.repository;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import webapp.model.Figure;
//
//@Repository
//public abstract class JdbcFigureRepository implements FigureRepository{
//    private JdbcTemplate jdbc;
//    @Override
//    public void update(Figure figure, String id) {
//        jdbc.update("update figures set code = ?, name = ?, price = ?, des = ? " +
//                        "where id = ?", figure.getCode(), figure.getName(),
//                figure.getPrice(), figure.getDes(), id);
//    }
//}
