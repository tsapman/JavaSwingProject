package backEnd;


//data that we pass as a string in the theory tabs of the app the data have a html format
public class Theory {
    public String AlgebraTheory(){
        String theory = "<html>\n" +
                "<head>" +
                "    <title>Algebra</title>" +
                "</head>" +
                "<body><h2 color=\"red\">What is Algebra?</h2>" +
                "<p>" +
                "    Algebra is the part of mathematics that helps represent problems or situations in the form of mathematical expressions" +
                "</p>" +
                "<p>" +
                "    In algebra, we use numbers like 2, −7, 0.068 etc., which have a definite or fixed value." +
                "</p>" +
                "    In algebra we use variables like x, y, and z along with numbers" +
                "<p>" +
                "The basic rules of algebra are the commutative rule of addition, the commutative rule of multiplication, the associative rule of" +
                "</p>"+
                "<p>" +
                "addition, the associative rule of multiplication, and the distributive property of multiplication. These rules tell us the ways that addition" +
                "</p>"+
                "<p>" +
                "and multiplication (and by extension, subtraction and division, respectively) behave." +
                "</p>"+
                "<p>" +
                "\n\n" +
                "</p>"+
                "<h2 color=\"blue\">How to do Algebra</h2>"+
                "<p><strong>Example 1:</strong> Find the value of x in the following equation using the Algebra concepts. 3x + 4 = 28</p>"+
                "<p><strong>Solution:</strong></p>"+
                "<p>3x + 4 = 28</p>"+
                "<p>3x = 28 - 4</p>"+
                "<p>3x = 24</p>"+
                "<p>x = 8</p>"+
                "<p>Therefore, the value of x = 8</p>"+
                "</body>" +
                "</html>";

        return theory;
    }

    public String geometryTheory(){
        String theory = "<html>\n" +
                "<head>" +
                "    <title>Geometry</title>" +
                "</head>" +
                "<body><h2 color=\"red\">What is Geometry?</h2>"+
                "<p>Geometry is derived from Ancient Greek words – 'Geo' means 'Earth' and 'metron' means 'measurement'</p>"+
                "<p>" +
                " Geometry is, along with arithmetic, one of the oldest branches of mathematics." +
                "</p>" +
                "<p>" +
                "  In Euclidean geometry, there are two-dimensional shapes and three-dimensional shapes." +
                "</p>" +
                "<p> In a plane geometry, 2d shapes such as triangles, squares, rectangles, circles are also called flat shapes.</p>"+
                "<p>" +
                "\n\n" +
                "</p>"+
                "<p><strong>Examples:</strong></p>"+
                "<p>" +
                "\n" +
                "</p>" +
                "<p>A triangle is a 3 sided shape, and the sum of its 3 interior angles is 180˚</p>"+
                "<p>A square, rectangle or quadrilateral are 4 sided shapes, and the sum of their 4 interior angles is 360˚</p>"+
                "<p>Other polygons like the pentagon, hexagon, heptagon, octagon have 5, 6, 7, 8 sides respectively and varying angles.</p>"+
                "<p>A circle is the set of all points equal in distance from a center point.</p>"+
                "</body>" +
                "</html>";

        return theory;
    }
}
