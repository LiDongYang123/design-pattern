package chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ChainFilter chainFilter = new ChainFilter();
        chainFilter.addFilter(new HTMLFilter())
                .addFilter(new URLFilter());
        chainFilter.doFilter();
    }
}


interface Filter {
    boolean doFilter();
}

class ChainFilter implements Filter{

    private List<Filter> filterList = new ArrayList<Filter>();

    public ChainFilter addFilter(Filter filter) {
        filterList.add(filter);
        return this;
    }

    @Override
    public boolean doFilter() {
        if (null == filterList && filterList.size() == 0) return true;
        for (Filter filter : filterList) {
            if (!filter.doFilter()) return false;
        }
        return true;
    }
}


class URLFilter implements Filter{

    @Override
    public boolean doFilter() {
        System.out.println("URL is executing");
        return true;
    }
}

class HTMLFilter implements Filter{

    @Override
    public boolean doFilter() {
        System.out.println("HTML is executing");
        return true;
    }
}
