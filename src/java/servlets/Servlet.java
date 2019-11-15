/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arlet
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        
        
        
        
       
        

String usuarioCorrecto = "Arleth Karina";
        String passCorrecto = "12345678";
        
        String pUsuario = request.getParameter("usuario");
        String pPassword = request.getParameter("password");
        
        boolean nuevoUsuario = true;
        
        //Obtenemos todas las cookies
        Cookie[] cookies = request.getCookies();
        
        //Buscamos si ya existe una cookie creada con anterioridad.
        //Llamada visitanteRecurrente.
        if (cookies != null)
        {
            for (Cookie c : cookies)
            {
                if (c.getName().equals("visitanteRecurrente") && c.getValue().equals("si"))
                {
                    //En caso de que ya exista una cookie indicando.
                    //ya que existe un usuario registrado con anterioridad
                    //ponemos la bandera en falso y salimos del ciclo.
                    nuevoUsuario = false;
                    break;
                }
            }
            
            
        }
        String anuncio = null;
            if(nuevoUsuario)
            {
                //En caso de ser un usuario nuevo creamos el objeto cookie.
                Cookie visitanteCookie = new Cookie ("visitanteRecurrente", "si");
                //Agregamos la cookie en la respuesta
                response.addCookie(visitanteCookie);
                anuncio = "Gracias por visitar nuestro sitio";
                
            }
            else
            {
                anuncio = "Gracias por visitar NUEVAMENTE nuestro sitio";
            }
            
            //Escribimos la salida.
            response.setContentType("text/html");
            
            
            HttpSession sesion = request.getSession();
        String titulo2 = null;
        
        //Pedimos el atribulo, y verificamos si existe
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        
        //Si es igual a nulo, quiere decir que es la primera vez que accedemos al recurso.
        if (contadorVisitas == null)
        {
            contadorVisitas = new Integer(1);
            titulo2 = "Bienvenido por primera vez...";
        }
        else
        {
           //Si es distinto de nulo, incrementamos el contador
            titulo2 = "Bienvenido nuevamente...";
            contadorVisitas += 1;
        }
        
        //En cualquier caso, agregamos el valor del contador a la sesion.
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        

        response.setContentType("text/html;charset=UTF-8");
        
            
            

        
        

        
        
        
        try(PrintWriter out = response.getWriter()){
            String titulo = null, mensaje = null;
            String tipoNavegador = request.getHeader("User-Agent");
            
            //Obtener informacion de los headers.
            String metodoHttp = request.getMethod();
            String ur = request.getRequestURI();
           
       
            
            
            
            
            
            System.out.println("El tipo de navegador es: " + tipoNavegador);
            
            if(tipoNavegador!=null && tipoNavegador.contains("Trident"))
            {
                titulo = "Navegador Internet Explorer";
                mensaje = "Estas navegando en Internet Explorer";
            }
            
            if(tipoNavegador!=null && tipoNavegador.contains("Firefox")){
                titulo = "Navegador Firefox";
                mensaje = "Estas navegando en Firefox";
            }
            
            if(tipoNavegador!=null && tipoNavegador.contains("Chrome")){
                titulo = "Google Chrome";
                mensaje = "Estas navegando en Chrome";
            }
            
            
            
            
            
        if(usuarioCorrecto.equals(pUsuario) && passCorrecto.equals(pPassword))
        {
          
            
            out.println("<html lang=\"en\">");
                out.println("<head>");
                out.println("<title>Francia sin terrorismo</title>\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
"    \n" +
"    <link href=\"https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,600,700,800,900&display=swap\" rel=\"stylesheet\">\n" +
"\n" +
"    <link rel=\"stylesheet\" href=\"css/open-iconic-bootstrap.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"css/animate.css\">\n" +
"    \n" +
"    <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n" +
"\n" +
"    <link rel=\"stylesheet\" href=\"css/aos.css\">\n" +
"\n" +
"    <link rel=\"stylesheet\" href=\"css/ionicons.min.css\">\n" +
"\n" +
"    <link rel=\"stylesheet\" href=\"css/bootstrap-datepicker.css\">\n" +
"    <link rel=\"stylesheet\" href=\"css/jquery.timepicker.css\">\n" +
"\n" +
"    \n" +
"    <link rel=\"stylesheet\" href=\"css/flaticon.css\">\n" +
"    <link rel=\"stylesheet\" href=\"css/icomoon.css\">\n" +
"    <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
"    \n" +
"    \n" +
"    \n" +
"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\n" +
"  <div class=\"container-fluid\">\n" +
"    <div class=\"navbar-header\">\n" +
"        <img src=\"images/francia.jpg\" width=\"100\" height=\"50\">\n" +
"        <a class=\"navbar-brand\" href=\"#\">FRANCIA </a>\n" +
"        \n" +
"        \n" +
"    </div>\n" +
"    <ul class=\"navbar-nav\">\n" +
"      </li>\n" +              
"      <li><a class=\"nav-link\" href=\"usuario.html\">Usuario</a></li>\n" +
                        "      <li><a class=\"nav-link\" href=\"duda.html\">Duda</a></li>\n" +
                        "      <li><a class=\"nav-link\" href=\"rol.html\">Rol</a></li>\n" +
"      \n" +
"      \n" +
"      \n" +
"      \n" +
"    </ul>\n" +
"     \n" +
"    <ul class=\"nav navbar-nav navbar-right\">\n" +
                        "      <li><a class=\"nav-link\"><span class=\"glyphicon glyphicon-user\"></span>" +  usuarioCorrecto   + "</a></li>\n" +
"      <li><a href=\"index.html\" class=\"nav-link\"><span class=\"glyphicon glyphicon-user\"></span>Cerrar Sesion</a></li>\n" +

                        
"    </ul>\n" +
"      \n" +
"  </div>\n" +
"     \n" +
"</nav>\n" +
"      \n" +
        "       <h3 align=\"center\">Informacion del navegador: " + mensaje + "</h3>\n" +
                        "       <h3 align=\"center\">"  + anuncio + "</h3>\n" +
                                "       <h3 align=\"center\">Numero de Accesos: "  + contadorVisitas + "</h3>\n" +
                                        "       <h3 align=\"center\">"  + titulo2 + "</h3>\n" +
                                                "       <h3 align=\"center\">"  + metodoHttp + "</h3>\n" +
                                                        "       <h3 align=\"center\">"  + ur + "</h3>\n");
                                                
                                                                
                                                                
                                                                out.println("<div align=\"center\">");
        Enumeration cabeceros = request.getHeaderNames();
            while(cabeceros.hasMoreElements())
            {
                String nombreCabecero = (String) cabeceros.nextElement();
            out.println("<b>"+nombreCabecero + "</b>");
            out.println(request.getHeader(nombreCabecero));
            out.println("<br>");
            }
                                                                
                                                                
                                                

                                                        
out.println("    <!-- END nav -->\n" +
"    \n" +
"    <div class=\"hero-wrap ftco-degree-bg\" style=\"background-image: url('images/francia1.jpg');\" data-stellar-background-ratio=\"0.5\">\n" +
"      <div class=\"overlay\"></div>\n" +
"      <div class=\"container\">\n" +
"        <div class=\"row no-gutters slider-text justify-content-center align-items-center\">\n" +
"          <div class=\"col-lg-8 col-md-6 ftco-animate d-flex align-items-end\">\n" +
"          	<div class=\"text text-center\">\n" +
"                    <h1 class=\"mb-4\"><strong>\"SI QUIERES LA PAZ, NO HABLES CON TUS AMIGOS. HABLA CON TUS ENEMIGOS\"</strong> </h1>\n" +
"                    <h2 style=\"font-size: 20px;\"><strong>- Dayan</strong></h2>\n" +
"	            \n" +
"            </div>\n" +
"          </div>\n" +
"        </div>\n" +
"      </div>\n" +
"      \n" +
"     \n" +
"      \n" +
"\n" +
"    <section class=\"ftco-section ftco-no-pb\">\n" +
"      <div class=\"container\">\n" +
"      	<div class=\"row justify-content-center\">\n" +
"          <div class=\"col-md-12 heading-section text-center ftco-animate mb-5\">\n" +
"          	<span class=\"subheading\">INSTITUCIONES</span>\n" +
"            <h2 class=\"mb-2\">AQUELLAS QUE TRABAJAN DIA CON DIA CONTRA EL TERRORISMO</h2>\n" +
"          </div>\n" +
"        </div>\n" +
"        <div class=\"row d-flex\">\n" +
"          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">\n" +
"            <div class=\"media block-6 services d-block text-center\">\n" +
"            	<div class=\"icon d-flex justify-content-center align-items-center\">    <img class=\"card-img-top, img-rounded\" src=\"images/institucion1.jpg\" alt=\"Card image\" style=\"width:100%\">\n" +
"</div>\n" +
"              <div class=\"media-body py-md-4\">\n" +
"                <h3>Accion del Conssejo de Seguridad contra AlQaeda</h3>\n" +
"                <button type=\"button\" class=\"btn btn-warning\" href=\"#\">Mas informacion</button>\n" +
"              </div>\n" +
"            </div>      \n" +
"          </div>\n" +
"          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">\n" +
"            <div class=\"media block-6 services d-block text-center\">\n" +
"            	<div class=\"icon d-flex justify-content-center align-items-center\">    <img class=\"card-img-bottom, img-rounded\" src=\"images/institucion2.jpg\" alt=\"Card image\" style=\"width:100%\">\n" +
"</div>\n" +
"              <div class=\"media-body py-md-4\">\n" +
"                <h3>La accion de la Asamblea General</h3>\n" +
"                      <button type=\"button\" class=\"btn btn-warning\" href=\"#\">Mas informacion</button>\n" +
"\n" +
"              </div>\n" +
"            </div>      \n" +
"          </div>\n" +
"          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">\n" +
"            <div class=\"media block-6 services d-block text-center\">\n" +
"            	<div class=\"icon d-flex justify-content-center align-items-center\"><img class=\"card-img-bottom\" src=\"images/institucion3.jpg\" alt=\"Card image\" style=\"width:100%\"></div>\n" +
"              <div class=\"media-body py-md-4\">\n" +
"                <h3>La accion del Consejo de Seguridad contra el terrorismo.</h3>\n" +
"                      <button type=\"button\" class=\"btn btn-warning\" href=\"#\">Mas informacion</button>\n" +
"              </div>\n" +
"            </div>      \n" +
"          </div>\n" +
"          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">\n" +
"            <div class=\"media block-6 services d-block text-center\">\n" +
"            	<div class=\"icon d-flex justify-content-center align-items-center\"><img class=\"card-img-bottom\" src=\"images/onu.png\" alt=\"Card image\" style=\"width:100%\"></div>\n" +
"              <div class=\"media-body py-md-4\">\n" +
"                <h3>Derechos Humanos y la lucha contra el terrorismo</h3>\n" +
"                      <button type=\"button\" class=\"btn btn-warning\" href=\"#\">Mas informacion</button>\n" +
"\n" +
"              </div>\n" +
"            </div>      \n" +
"          </div>\n" +
"        </div>\n" +
"      </div>\n" +
"    </section>\n" +
"\n" +
"    <section class=\"ftco-section goto-here\">\n" +
"    	<div class=\"container\">\n" +
"    		<div class=\"row justify-content-center\">\n" +
"          <div class=\"col-md-12 heading-section text-center ftco-animate mb-5\">\n" +
"          	<span class=\"subheading\">EVENTOS</span>\n" +
"            <h2 class=\"mb-2\">TU PUEDES ASISTIR Y PONER TU GRANITO DE ARENA!</h2>\n" +
"          </div>\n" +
"        </div>\n" +
"        <div class=\"row\">\n" +
"        	<div class=\"col-md-4\">\n" +
"        		<div class=\"property-wrap ftco-animate\">\n" +
"                            <img class=\"card-img-bottom\" src=\"images/evento.jpg\" alt=\"Card image\" style=\"width:100%\">\n" +
"        			<div class=\"text\">        			\n" +
"        				<h3><a href=\"#\">Día Internacional del Personal de Paz de las Naciones Unidas</a></h3>\n" +
"        				<span class=\"location\">29.05.19</span>\n" +
"        				<a href=\"#\" class=\"d-flex align-items-center justify-content-center btn-custom\">\n" +
"        					<span class=\"ion-ios-link\"></span>\n" +
"        				</a>\n" +
"        			</div>\n" +
"        		</div>\n" +
"        	</div>\n" +
"        	<div class=\"col-md-4\">\n" +
"        		<div class=\"property-wrap ftco-animate\">\n" +
"                                                        <img class=\"card-img-bottom\" src=\"images/evento2.jpg\" alt=\"Card image\" style=\"width:100%\">\n" +
"        			<div class=\"text\">\n" +
"        				<h3><a href=\"#\">Ingreso de nuevos miembros en el Consejo de Seguridad.</a></h3>\n" +
"        				<span class=\"location\">02.01.19</span>\n" +
"        				<a href=\"#\" class=\"d-flex align-items-center justify-content-center btn-custom\">\n" +
"        					<span class=\"ion-ios-link\"></span>\n" +
"        				</a>\n" +
"        			</div>\n" +
"        		</div>\n" +
"        	</div>\n" +
"        	<div class=\"col-md-4\">\n" +
"        		<div class=\"property-wrap ftco-animate\">\n" +
"                             <img class=\"card-img-bottom\" src=\"images/evento3.jpg\" alt=\"Card image\" style=\"width:100%\">\n" +
"\n" +
"        			<div class=\"text\">\n" +
"        				<h3><a href=\"#\">Organización marítima internacional - Relección de Francia en el Consejo.</a></h3>\n" +
"        				<span class=\"location\">05.12.19</span>\n" +
"        				<a href=\"#\" class=\"d-flex align-items-center justify-content-center btn-custom\">\n" +
"        					<span class=\"ion-ios-link\"></span>\n" +
"        				</a>\n" +
"        			</div>\n" +
"        		</div>\n" +
"        	</div>\n" +
"        </div>\n" +
"    	</div>\n" +
"    </section>\n" +
"\n" +
"    <section class=\"ftco-section ftco-degree-bg services-section img mx-md-5\" style=\"background-image: url(images/historia.jpg);\">\n" +
"    	<div class=\"overlay\"></div>\n" +
"    	<div class=\"container\">\n" +
"    		<div class=\"row justify-content-start mb-5\">\n" +
"          <div class=\"col-md-6 text-center heading-section heading-section-white ftco-animate\">\n" +
"          	<span class=\"subheading\">FECHAS TERRORISTAS</span>\n" +
"            <h2 class=\"mb-3\">ENTRE 2014 Y 2018 FRANCIA SUFRIÓ 8 ATENTADOS</h2>\n" +
"          </div>\n" +
"        </div>\n" +
"    		<div class=\"row\">\n" +
"    			<div class=\"col-md-6\">\n" +
"    				<div class=\"row\">\n" +
"		    			<div class=\"col-md-12 col-lg-6 d-flex align-self-stretch ftco-animate\">\n" +
"		            <div class=\"media block-6 services services-2\">\n" +
"		              <div class=\"media-body py-md-4 text-center\">\n" +
"		              	<div class=\"icon mb-3 d-flex align-items-center justify-content-center\"><span>2015</span></div>\n" +
"		                <h3>9 de enero</h3>\n" +
"		                <p>Toma de rehenes supermecado kosher en París. 4 muertos.</p>\n" +
"		              </div>\n" +
"		            </div>      \n" +
"		          </div>\n" +
"		          <div class=\"col-md-12 col-lg-6 d-flex align-self-stretch ftco-animate\">\n" +
"		            <div class=\"media block-6 services services-2\">\n" +
"		              <div class=\"media-body py-md-4 text-center\">\n" +
"		              	<div class=\"icon mb-3 d-flex align-items-center justify-content-center\"><span>2015</span></div>\n" +
"		                <h3>26 de junio</h3>\n" +
"		                <p>Ataque en empresa gasística en Saint-Quentin-Fallavier. 1 muerto.</p>\n" +
"		              </div>\n" +
"		            </div>      \n" +
"		          </div>\n" +
"		          <div class=\"col-md-12 col-lg-6 d-flex align-self-stretch ftco-animate\">\n" +
"		            <div class=\"media block-6 services services-2\">\n" +
"		              <div class=\"media-body py-md-4 text-center\">\n" +
"		              	<div class=\"icon mb-3 d-flex align-items-center justify-content-center\"><span>2015</span></div>\n" +
"		                <h3>13 de noviembre</h3>\n" +
"		                <p>Serie de atentados en París (Bataclán, Estadio de Francia, etc.). 130 muertos.</p>\n" +
"		              </div>\n" +
"		            </div>      \n" +
"		          </div>\n" +
"		          <div class=\"col-md-12 col-lg-6 d-flex align-self-stretch ftco-animate\">\n" +
"		            <div class=\"media block-6 services services-2\">\n" +
"		              <div class=\"media-body py-md-4 text-center\">\n" +
"		              	<div class=\"icon mb-3 d-flex align-items-center justify-content-center\"><span>2016</span></div>\n" +
"		                <h3>14 de julio</h3>\n" +
"		                <p>Atropello en el Día Nacional de Francia en Niza. 84 muertos.</p>\n" +
"		              </div>\n" +
"		            </div>      \n" +
"		          </div>\n" +
"		        </div>\n" +
"		      </div>\n" +
"    		</div>\n" +
"    	</div>\n" +
"    </section>\n" +
"\n" +
"    <section class=\"ftco-section ftco-no-pb\">\n" +
"			<div class=\"container\">\n" +
"				<div class=\"row no-gutters\">\n" +
"					<div class=\"col-md-6 p-md-5 img img-2 d-flex justify-content-center align-items-center\" style=\"background-image: url(images/pazfrancia.jpg);\">\n" +
"					</div>\n" +
"					<div class=\"col-md-6 wrap-about py-md-5 ftco-animate\">\n" +
"	          <div class=\"heading-section p-md-5\">\n" +
"	            <h2 class=\"mb-4\" align=\"center\">¿POR QUE OCURRIERON LOS ATENTADOS TERRORISTAS EN PARIS?</h2>\n" +
"\n" +
"	            <p align=\"justify\">El analista político francés Lorenzo Müller considera que los atentados terroristas del viernes en París \"respondieron a dos razones principales: el rol de Francia en el escenario internacional y en la lucha contra el Ejército Islámico, y la falta de integración de muchos norteafricanos y musulmanes aquí en Francia\".</p>\n" +
"	            <p align=\"justify\">\"La política seguida por los diversos gobiernos, de izquierda y de derecha, no ha sido al final muy eficiente en términos de integración y de aceptación, por parte de la población musulmana, de los valores de la República\", subrayó. Müller indicó que \"una parte de la comunidad musulmana no se ha integrado después de dos o tres generaciones pasadas en este país. Son gente que tienen todavía problemas de identidad nacional. No son norteafricanos, no son franceses, viven con un malestar y este malestar tiene que ser corregido\", dijo, señalando que esta es la única forma de intergrarlos a la república francesa.</p>\n" +
"	          </div>\n" +
"					</div>\n" +
"				</div>\n" +
"			</div>\n" +
"		</section>\n" +
"\n" +
"		\n" +
"\n" +
"    <section class=\"ftco-section testimony-section\">\n" +
"      <div class=\"container\">\n" +
"        <div class=\"row justify-content-center mb-5\">\n" +
"          <div class=\"col-md-7 text-center heading-section ftco-animate\">\n" +
"          	<span class=\"subheading\">MEDIDAS DE PREVENCIÓN</span>\n" +
"            <h2 class=\"mb-3\">¿NO SABES COMO PREVENIR EL TERRORISMO? TE DEJO ALGUNAS RECOMENDACIONES...</h2>\n" +
"          </div>\n" +
"        </div>\n" +
"        <div class=\"row ftco-animate\">\n" +
"          <div class=\"col-md-12\">\n" +
"            <div class=\"carousel-testimony owl-carousel ftco-owl\">\n" +
"              <div class=\"item\">\n" +
"                <div class=\"testimony-wrap py-4\">\n" +
"                  <div class=\"text\">\n" +
"                    <p class=\"mb-4\">El plan Vigipirate, dispositivo permanente de vigilancia, prevención y protección, es una de las principales herramientas de lucha antiterrorista en Francia.</p>\n" +
"                    <div class=\"d-flex align-items-center\">\n" +
"                    	<div class=\"user-img\" style=\"background-image: url(images/vigiripate.png)\"></div>\n" +
"                    	<div class=\"pl-3\">\n" +
"		                    <p class=\"name\">EL PLAN VIGIPIRATE</p>\n" +
"		                  </div>\n" +
"	                  </div>\n" +
"                  </div>\n" +
"                </div>\n" +
"              </div>\n" +
"              <div class=\"item\">\n" +
"                <div class=\"testimony-wrap py-4\">\n" +
"                  <div class=\"text\">\n" +
"                    <p class=\"mb-4\">Efectivos policiales y de la gendarmería, apoyados por soldados del ejército francés, han sido desplegados permanentemente en los puntos sensibles del territorio.</p>\n" +
"                    <div class=\"d-flex align-items-center\">\n" +
"                    	<div class=\"user-img\" style=\"background-image: url(images/sentinelle.png)\"></div>\n" +
"                    	<div class=\"pl-3\">\n" +
"		                    <p class=\"name\">LA OPERACIÓN SENTINELLE</p>\n" +
"		                  </div>\n" +
"	                  </div>\n" +
"                  </div>\n" +
"                </div>\n" +
"              </div>\n" +
"              <div class=\"item\">\n" +
"                <div class=\"testimony-wrap py-4\">\n" +
"                  <div class=\"text\">\n" +
"                    <p class=\"mb-4\">Para la vuelta a las aulas en 2016, el Estado ha invertido 30 millones de euros con el fin de reforzar la seguridad de los estudiantes en los campus.</p>\n" +
"                    <div class=\"d-flex align-items-center\">\n" +
"                    	<div class=\"user-img\" style=\"background-image: url(images/seguridad.jpg)\"></div>\n" +
"                    	<div class=\"pl-3\">\n" +
"		                    <p class=\"name\">CENTROS UNIVERSITARIOS</p>\n" +
"		                  </div>\n" +
"	                  </div>\n" +
"                  </div>\n" +
"                </div>\n" +
"              </div>\n" +
"              <div class=\"item\">\n" +
"                <div class=\"testimony-wrap py-4\">\n" +
"                  <div class=\"text\">\n" +
"                    <p class=\"mb-4\">Son recomendables algunas medidas de sentido común para disfrutar de una estancia segura en Francia.</p>\n" +
"                    <div class=\"d-flex align-items-center\">\n" +
"                    	<div class=\"user-img\" style=\"background-image: url(images/seguridad2.jpg)\"></div>\n" +
"                    	<div class=\"pl-3\">\n" +
"		                    <p class=\"name\">SEGURIDAD EN GENERAL</p>\n" +
"		                  </div>\n" +
"	                  </div>\n" +
"                  </div>\n" +
"                </div>\n" +
"              </div>\n" +
"              <div class=\"item\">\n" +
"                <div class=\"testimony-wrap py-4\">\n" +
"                  <div class=\"text\">\n" +
"                    <p class=\"mb-4\">Diferentes números de emergencias permiten contactar con los servicios de socorro gratuitamente en cualquier momento.</p>\n" +
"                    <div class=\"d-flex align-items-center\">\n" +
"                    	<div class=\"user-img\" style=\"background-image: url(images/numeros2.png)\"></div>\n" +
"                    	<div class=\"pl-3\">\n" +
"		                    <p class=\"name\">LOS NÚMEROS DE EMERGENCIA</p>\n" +
"		                  </div>\n" +
"	                  </div>\n" +
"                  </div>\n" +
"                </div>\n" +
"              </div>\n" +
"            </div>\n" +
"          </div>\n" +
"        </div>\n" +
"      </div>\n" +
"    </section>\n" +
"\n" +
"    \n" +
"\n" +
"    	\n" +
"\n" +
"    <footer class=\"ftco-footer ftco-section\">\n" +
"      <div class=\"container\">\n" +
"        <div class=\"row mb-5\">\n" +
"          <div class=\"col-md\">\n" +
"            <div class=\"ftco-footer-widget mb-4\" align=\"center\">\n" +
"              <ul class=\"ftco-footer-social list-unstyled mt-5\">\n" +
"                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>\n" +
"                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>\n" +
"                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>\n" +
"              </ul>\n" +
"            </div>\n" +
"          </div>\n" +
"          \n" +

"            \n" +
"             </div>\n" +
"            <br>\n" +
"          \n" +
"        <div class=\"row\">\n" +
"          <div class=\"col-md-12 text-center\">\n" +
"	\n" +
"            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n" +
"  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Francia sin terrorismo <i class=\"icon-heart color-red\" aria-hidden=\"true\"></i>\n" +
" </p>\n" +
"          </div>\n" +
"        </div>\n" +
"      </div>\n" +
"         \n" +
"    </footer>\n" +
"    \n" +
"  \n" +
"\n" +
"  <!-- loader -->\n" +
"  <div id=\"ftco-loader\" class=\"show fullscreen\"><svg class=\"circular\" width=\"48px\" height=\"48px\"><circle class=\"path-bg\" cx=\"24\" cy=\"24\" r=\"22\" fill=\"none\" stroke-width=\"4\" stroke=\"#eeeeee\"/><circle class=\"path\" cx=\"24\" cy=\"24\" r=\"22\" fill=\"none\" stroke-width=\"4\" stroke-miterlimit=\"10\" stroke=\"#F96D00\"/></svg></div>\n" +
"\n" +
"\n" +
"  <script src=\"js/jquery.min.js\"></script>\n" +
"  <script src=\"js/jquery-migrate-3.0.1.min.js\"></script>\n" +
"  <script src=\"js/popper.min.js\"></script>\n" +
"  <script src=\"js/bootstrap.min.js\"></script>\n" +
"  <script src=\"js/jquery.easing.1.3.js\"></script>\n" +
"  <script src=\"js/jquery.waypoints.min.js\"></script>\n" +
"  <script src=\"js/jquery.stellar.min.js\"></script>\n" +
"  <script src=\"js/owl.carousel.min.js\"></script>\n" +
"  <script src=\"js/jquery.magnific-popup.min.js\"></script>\n" +
"  <script src=\"js/aos.js\"></script>\n" +
"  <script src=\"js/jquery.animateNumber.min.js\"></script>\n" +
"  <script src=\"js/bootstrap-datepicker.js\"></script>\n" +
"  <script src=\"js/jquery.timepicker.min.js\"></script>\n" +
"  <script src=\"js/scrollax.min.js\"></script>\n" +
"  <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false\"></script>\n" +
"  <script src=\"js/google-map.js\"></script>\n" +
"  <script src=\"js/main.js\"></script>");
                
        
        
        out.println("</div");
        out.println("</body>");
        out.println("</html>");
        out.close();
            
        }
        
        else
        {
            response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
            
        }
      
        
        
                
                
        
        
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

    }// </editor-fold>

}
