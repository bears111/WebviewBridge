angular.module('myApp', 
				['ionic',
				'myApp.controllers',
				'myApp.services',
				'myApp.directives',
				])

   .run(function($ionicPlatform,$rootScope) {
      $rootScope.$on('$stateChangeStart',function(event, toState, toParams, fromState, fromParams, options){
	      console.log("toState--->",toState)
	      console.log("fromState--->", fromState)
       })
    })
    .config(function($stateProvider, $urlRouterProvider,$ionicConfigProvider) {
			
        $ionicConfigProvider.platform.ios.tabs.position('bottom');
        $ionicConfigProvider.platform.android.tabs.style('standard');
        $ionicConfigProvider.platform.android.tabs.position('standard');

        $ionicConfigProvider.platform.ios.navBar.alignTitle('center');
        $ionicConfigProvider.platform.android.navBar.alignTitle('left');
		
       

        // if none of the above states are matched, use this as the fallback
        $urlRouterProvider.otherwise('login');

        $stateProvider
            // setup an abstract state for the tabs directive
            .state('tab', {
                url: '/tab',
                templateUrl: 'templates/tabs.html'
            })

            
            .state('login',{
                url:'/login',
                templateUrl: 'templates/login.html',
                controller:'LoginCtrl'
            })

            
            .state('register',{
                url:'/register',
                templateUrl:'templates/register.html',
                controller:'RegisterCtrl'
            })
            .state('dash',{
                url:'/dash',
                templateUrl:'templates/tab-dash.html',
                controller:'DashCtrl',
                onExit: function(){
                    delete RainbowBridge.onJavaCompleteMainActivity;
                }
            })

            
            .state('modifyPassword',{
                url:'/modifyPassword',
                templateUrl:'templates/modifyPassword.html',
                controller:'ModifyPasswordCtrl'
            })
    });
