/**
 * Created by zhoupan on 2015/9/14.
 */
angular.module('myApp.controllers',[])
.controller('DashCtrl',['$scope', '$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state, $data) {
$scope.settings={};

$scope.showPopup=function(){
   RainbowBridge.callMethod('BridgePlug','showToast',{'msg':'I am showToast'},
   function(msg){
   alert(JSON.stringify(msg))});
}

RainbowBridge.onJavaCompleteMainActivity=function(res){
        alert("来之原生端的数据"+JSON.stringify(res));
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
        $scope.login = function(){
         /*console.log($scope.formUser);*/
         var myPopup = $ionicPopup.show({
                         title: '<b>登录</b>'
           });
           $timeout(function(){
           myPopup.close();
           $state.go("dash");
           },1000)
        };
}])
.controller('ModifyPasswordCtrl',['$scope', '$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state, $data) {}])
.controller('RegisterCtrl',['$scope','$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state , $data) {}])