package com.xulc.kitdemo.base;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {
    CompositeDisposable disposable;
    public BaseObserver(CompositeDisposable disposable) {
        this.disposable = disposable;
    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable.add(d);
    }

    @Override
    public void onNext(BaseResponse<T> tBaseResponse) {
        try {
            if (tBaseResponse.getErrorCode() == 0){
                onSuccess(tBaseResponse);
            }else {
                onFail(tBaseResponse);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable e) {
        BaseResponse<T> errorResponse = new BaseResponse<>();
        errorResponse.setErrorCode(-999);
        errorResponse.setErrorMsg(e.getMessage());
        onFail(errorResponse);

    }

    @Override
    public void onComplete() {
    }

    protected abstract void onSuccess(BaseResponse<T> tBaseResponse);

    protected abstract void onFail(BaseResponse<T> tBaseResponse);

}
