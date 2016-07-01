/**
 * Created by zhoupan on 2015/9/14.
 */
angular.module('myApp.controllers',[])
.controller('DashCtrl',['$scope', '$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state, $data) {
$scope.settings={};

$scope.showPopup=function(){
   RainbowBridge.callMethod('BridgePlug','showToast',{'msg':'I am showToast'},
   function(msg){
   alert(JSON.stringify(msg))},function(error){alert(error)});
}

RainbowBridge.onJavaCompleteMainActivity=function(res){
        alert(JSON.stringify(res));
};
$scope.showPopup1=function(){
   RainbowBridge.callMethod('BridgePlug','jumpActivity',{'msg':'I am showToast'},
   function(msg){
   }
   );
}

}])
.controller('LoginCtrl',['$scope', '$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state, $data) {
        $scope.formUser = {};

        //执行用户登录操作
        $scope.doLogin = function(){

        };

        $scope.showErrorMesPopup = function(title) {
            var myPopup = $ionicPopup.show({
                title: '<b>'+title+'</b>'
            });
            $timeout(function() {
                myPopup.close(); // 2秒后关闭
            }, 1000);
        };

        $scope.showSuccessMesPopup = function(title) {
            var myPopup = $ionicPopup.show({
                title: '<b>'+title+'</b>',
                template: '<p style="text-align: center"><ion-spinner icon="android" class="spinner-positive"></ion-spinner></p>'
            });
            $timeout(function() {
                myPopup.close(); // 2秒后关闭
                $state.go("tab.main");
            }, 2000);
        };
    }])
    
    
 .controller('ModifyPasswordCtrl',['$scope', '$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state, $data) {
        $scope.formUser = {};

        //执行用户登录操作
        $scope.doModify = function(){
             $data.modifyPassword("user", this.formUser).success(function(data){
                 if(data == null){
                     $scope.showErrorMesPopup("不存在该用户");
                 }else{
                     $scope.showSuccessMesPopup("正在修改请稍后");
                     $state.go("login");
                 }
          });
        };

        $scope.showErrorMesPopup = function(title) {
            var myPopup = $ionicPopup.show({
                title: '<b>'+title+'</b>'
            });
            $timeout(function() {
                myPopup.close(); // 2秒后关闭
            }, 1000);
        };

        $scope.showSuccessMesPopup = function(title) {
            var myPopup = $ionicPopup.show({
                title: '<b>'+title+'</b>',
                template: '<p style="text-align: center"><ion-spinner icon="android" class="spinner-positive"></ion-spinner></p>'
            });
            $timeout(function() {
                myPopup.close(); // 2秒后关闭
                $state.go("tab.main");
            }, 2000);
            $timeout(function(){

            },3000)
        };
    }])  

.controller('RegisterCtrl',['$scope','$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state , $data) {
        $scope.formUser = {};
        $scope.doRegister = function(){
            console.log($scope.formUser);
            $data.register("user",$scope.formUser).success(function(data){
                console.log(data,"true OR false");
                if(data != null){
                    $scope.showSuccessMesPopup("正在注册，请稍后");
                    $timeout(function() {
                        $scope.showErrorMesPopup("注册成功！");
                        $state.go("login");
                    }, 2000);
                }else{
                    $scope.showErrorMesPopup("用户名已被注册，请更换！");
                }
            });
        };


        $scope.showErrorMesPopup = function(title) {
            var myPopup = $ionicPopup.show({
                title: '<b>'+title+'</b>'
            });
            $timeout(function() {
                myPopup.close(); // 2秒后关闭
            }, 1000);
        };


        //  验证成功后提示框
        $scope.showSuccessMesPopup = function(title) {
            var myPopup = $ionicPopup.show({
                title: '<b>'+title+'</b>',
                template: '<p style="text-align: center"><ion-spinner icon="android"></ion-spinner></p>'
            });
            $timeout(function() {
                myPopup.close(); // 2秒后关闭
            }, 2000);
        };
    }])