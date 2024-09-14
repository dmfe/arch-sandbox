package net.dmfe.archsandbox.ioc;

public interface DependencyFactory {

    <T> T getDependency(Class<T> type);

}
