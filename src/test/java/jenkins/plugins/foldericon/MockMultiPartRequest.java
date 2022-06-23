package jenkins.plugins.foldericon;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.security.Principal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ReadListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.kohsuke.stapler.Ancestor;
import org.kohsuke.stapler.BindInterceptor;
import org.kohsuke.stapler.Stapler;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;
import org.kohsuke.stapler.WebApp;
import org.kohsuke.stapler.bind.BoundObjectTable;
import org.kohsuke.stapler.lang.Klass;

import net.sf.json.JSONObject;

/**
 * @author dkraemer
 */
public class MockMultiPartRequest implements StaplerRequest {

    private final byte[] buffer;
    private final ByteArrayInputStream stream;

    /**
     * @param buffer
     *            buffer
     */
    public MockMultiPartRequest(byte[] buffer) {
        this.buffer = buffer;
        this.stream = new ByteArrayInputStream(buffer);
    }

    @Override
    public int getContentLength() {
        return buffer.length;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return stream.read();
            }

            @Override
            public int read(byte[] b) throws IOException {
                return stream.read(b);
            }

            @Override
            public int read(byte[] b, int off, int len) throws IOException {
                return stream.read(b, off, len);
            }

            @Override
            public boolean isFinished() {
                return stream.available() != 0;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
                // NOP
            }

        };
    }

    @Override
    public String getContentType() {
        return "multipart/form-data; boundary=myboundary";
    }

    @Override
    public String getCharacterEncoding() {
        return "UTF-8";
    }

    @Override
    public String getHeader(String name) {
        return null;
    }

    @Override
    public String getAuthType() {
        return "";
    }

    @Override
    public Cookie[] getCookies() {
        return null;
    }

    @Override
    public long getDateHeader(String name) {
        return 0;
    }

    @Override
    public Enumeration getHeaders(String name) {
        return null;
    }

    @Override
    public Enumeration getHeaderNames() {
        return null;
    }

    @Override
    public int getIntHeader(String name) {
        return 0;
    }

    @Override
    public String getMethod() {
        return "";
    }

    @Override
    public String getPathInfo() {
        return "";
    }

    @Override
    public String getPathTranslated() {
        return "";
    }

    @Override
    public String getContextPath() {
        return "";
    }

    @Override
    public String getQueryString() {
        return "";
    }

    @Override
    public String getRemoteUser() {
        return "";
    }

    @Override
    public boolean isUserInRole(String role) {
        return false;
    }

    @Override
    public Principal getUserPrincipal() {
        return null;
    }

    @Override
    public String getRequestedSessionId() {
        return "";
    }

    @Override
    public String getRequestURI() {
        return "";
    }

    @Override
    public StringBuffer getRequestURL() {
        return new StringBuffer("");
    }

    @Override
    public String getServletPath() {
        return "";
    }

    @Override
    public HttpSession getSession(boolean create) {
        return null;
    }

    @Override
    public HttpSession getSession() {
        return null;
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return false;
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public Enumeration getAttributeNames() {
        return null;
    }

    @Override
    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {
        // NOP
    }

    @Override
    public String getParameter(String name) {
        return "";
    }

    @Override
    public Enumeration getParameterNames() {
        return null;
    }

    @Override
    public String[] getParameterValues(String name) {
        return null;
    }

    @Override
    public Map getParameterMap() {
        return null;
    }

    @Override
    public String getProtocol() {
        return "";
    }

    @Override
    public String getScheme() {
        return "";
    }

    @Override
    public String getServerName() {
        return "";
    }

    @Override
    public int getServerPort() {
        return 0;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return null;
    }

    @Override
    public String getRemoteAddr() {
        return "";
    }

    @Override
    public String getRemoteHost() {
        return "";
    }

    @Override
    public void setAttribute(String name, Object o) {
        // NOP
    }

    @Override
    public void removeAttribute(String name) {
        // NOP
    }

    @Override
    public Locale getLocale() {
        return Locale.getDefault();
    }

    @Override
    public Enumeration getLocales() {
        return null;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        return null;
    }

    @Override
    public String getRealPath(String path) {
        return "";
    }

    @Override
    public long getContentLengthLong() {
        return 0;
    }

    @Override
    public int getRemotePort() {
        return 0;
    }

    @Override
    public String getLocalName() {
        return "";
    }

    @Override
    public String getLocalAddr() {
        return "";
    }

    @Override
    public int getLocalPort() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        return null;
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse)
            throws IllegalStateException {
        return null;
    }

    @Override
    public boolean isAsyncStarted() {
        return false;
    }

    @Override
    public boolean isAsyncSupported() {
        return false;
    }

    @Override
    public AsyncContext getAsyncContext() {
        return null;
    }

    @Override
    public DispatcherType getDispatcherType() {
        return null;
    }

    @Override
    public String changeSessionId() {
        return "";
    }

    @Override
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        return false;
    }

    @Override
    public void login(String username, String password) throws ServletException {
        // NOP
    }

    @Override
    public void logout() throws ServletException {
        // NOP
    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return null;
    }

    @Override
    public Part getPart(String name) throws IOException, ServletException {
        return null;
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
        return null;
    }

    @Override
    public Stapler getStapler() {
        return null;
    }

    @Override
    public WebApp getWebApp() {
        return null;
    }

    @Override
    public String getRestOfPath() {
        return "";
    }

    @Override
    public String getOriginalRestOfPath() {
        return "";
    }

    @Override
    public String getRequestURIWithQueryString() {
        return "";
    }

    @Override
    public StringBuffer getRequestURLWithQueryString() {
        return new StringBuffer("");
    }

    @Override
    public RequestDispatcher getView(Object it, String viewName) throws IOException {
        return null;
    }

    @Override
    public RequestDispatcher getView(Class clazz, String viewName) throws IOException {
        return null;
    }

    @Override
    public RequestDispatcher getView(Klass<?> clazz, String viewName) throws IOException {
        return null;
    }

    @Override
    public String getRootPath() {
        return "";
    }

    @Override
    public String getReferer() {
        return "";
    }

    @Override
    public List<Ancestor> getAncestors() {
        return null;
    }

    @Override
    public Ancestor findAncestor(Class type) {
        return null;
    }

    @Override
    public <T> T findAncestorObject(Class<T> type) {
        return null;
    }

    @Override
    public Ancestor findAncestor(Object o) {
        return null;
    }

    @Override
    public boolean hasParameter(String name) {
        return false;
    }

    @Override
    public String getOriginalRequestURI() {
        return "";
    }

    @Override
    public boolean checkIfModified(long timestampOfResource, StaplerResponse rsp) {
        return false;
    }

    @Override
    public boolean checkIfModified(Date timestampOfResource, StaplerResponse rsp) {
        return false;
    }

    @Override
    public boolean checkIfModified(Calendar timestampOfResource, StaplerResponse rsp) {
        return false;
    }

    @Override
    public boolean checkIfModified(long timestampOfResource, StaplerResponse rsp, long expiration) {
        return false;
    }

    @Override
    public void bindParameters(Object bean) {
        // NOP
    }

    @Override
    public void bindParameters(Object bean, String prefix) {
        // NOP
    }

    @Override
    public <T> List<T> bindParametersToList(Class<T> type, String prefix) {
        return null;
    }

    @Override
    public <T> T bindParameters(Class<T> type, String prefix) {
        return null;
    }

    @Override
    public <T> T bindParameters(Class<T> type, String prefix, int index) {
        return null;
    }

    @Override
    public <T> T bindJSON(Class<T> type, JSONObject src) {
        return null;
    }

    @Override
    public <T> T bindJSON(Type genericType, Class<T> erasure, Object json) {
        return null;
    }

    @Override
    public void bindJSON(Object bean, JSONObject src) {
        // NOP
    }

    @Override
    public <T> List<T> bindJSONToList(Class<T> type, Object src) {
        return null;
    }

    @Override
    public BindInterceptor getBindInterceptor() {
        return null;
    }

    @Override
    public BindInterceptor setBindListener(BindInterceptor bindListener) {
        return null;
    }

    @Override
    public BindInterceptor setBindInterceptpr(BindInterceptor bindListener) {
        return null;
    }

    @Override
    public BindInterceptor setBindInterceptor(BindInterceptor bindListener) {
        return null;
    }

    @Override
    public JSONObject getSubmittedForm() throws ServletException {
        return null;
    }

    @Override
    public FileItem getFileItem(String name) throws ServletException, IOException {
        return null;
    }

    @Override
    public boolean isJavaScriptProxyCall() {
        return false;
    }

    @Override
    public BoundObjectTable getBoundObjectTable() {
        return null;
    }

    @Override
    public String createJavaScriptProxy(Object toBeExported) {
        return null;
    }
}
