package com.xin.box.lazy;

public class LazyInitializer<T> {

    public interface ILazyInitializerFunc<T> {

        T initializer();
    }

    private T mValue;

    ILazyInitializerFunc<T> mInitializer;

    public LazyInitializer(ILazyInitializerFunc<T> initializer) {
        this.mInitializer = initializer;
    }

    public T get() {
        if (null != mValue) {
            return mValue;
        }
        synchronized (this) {
            if (null == mValue) {
                mValue = mInitializer.initializer();
                if (null == mValue) {
                    throw new IllegalArgumentException("initializer must return a not null value.");
                }
                mInitializer = null;
            }
            return mValue;
        }
    }
}
