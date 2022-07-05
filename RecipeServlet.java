

@WebServlet("/recipes")

public class RecipeServlet extends HttpServlet {
    
                //below shouldn't be needed if properly added to context.xml and web.xml 
    @Resource(name="jdbc/DinnersDone")
    private dataSource dataSource;
    private RecipeDao recipeDao;

    @Override
    public void init() {
        recipeDao = new RecipeDao(dataSource);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            List<Recipe> recipes = recipeDao.list();
                     //the following will make the recipe list available as ${recipes} in JSP
            request.setAttribute("recipes", recipes);

            request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);

        } catch (SQLException sqlEx) {
            throw new ServletException("Cannot retrieve recipes from database.", sqlEx);
        }
    }

}