[dagger](https://dagger.dev/dev-guide/android)



1.在 BaseActivity onCreate前注册  AndroidInjection.inject(this)，Fragment在super.onAttach(context) 前调用AndroidSupportInjection.inject(this)


2.创建 MainActivitySubComponent或者 TestFragmentSubComponent
@Subcomponent(modules = [(StudentModule::class)])
interface MainActivitySubComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder:AndroidInjector.Builder<MainActivity>()
}


@Subcomponent(modules = [(PersonModule::class)])
interface TestFragmentSubComponent:AndroidInjector<TestFragment>{
    @Subcomponent.Builder
    abstract class Builder:AndroidInjector.Builder<TestFragment>()
}


3.创建 ActivityModule或者 FragmentModule
@Module(subcomponents = [(MainActivitySubComponent::class),(多个的话在这里进行添加)])
abstract class ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivity(builder: MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}



@Module(subcomponents = [(TestFragmentSub::class),(多个的话在这里进行添加)])
abstract class FragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(TestFragment::class)
    abstract fun bindTestFragment(builder: TestFragmentSubComponent.Builder): AndroidInjector.Factory<out Fragment>
}


4.创建 ApplicationComponent
@Component(modules = [(ActivityModule::class), (FragmentModule::class)])
interface ApplicationComponent {
    fun inject(app: MyApp)
}

5.初始化
class MyApp : Application(), HasActivityInjector, HasSupportFragmentInjector  {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        ApplicationComponent.create().inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityInjector
    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return fragmentInjector
    }
}









