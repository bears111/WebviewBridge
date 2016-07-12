/**
 * Created by zhoupan on 2015/9/14.
 */
angular.module('myApp.controllers',[])
.controller('DashCtrl',['$scope', '$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state, $data) {
$scope.settings={};

$scope.showPopup=function(){
   RainbowBridge.callMethod('BridgePlug','showToast',{'msg':'I am showToast'},
   function(msg){
   alert(JSON.stringify(msg));
   console.info(msg);
   });

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
.controller('LoginCtrl',['$scope', '$ionicPopup','$http', '$timeout', '$state',  '$data', function($scope, $ionicPopup,$http,$timeout, $state, $data) {
        $scope.formUser = {};
        //执行用户登录操作
        $scope.login = function(){
        if($scope.formUser){
         alert($scope.formUser.phoneNumber+"检验完的"+$scope.formUser.password);
         $state.go("dash",{loginSuccess:123});
        }

 }


}])
.controller('ModifyPasswordCtrl',['$scope', '$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state, $data) {}])
.controller('RegisterCtrl',['$scope','$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state , $data) {}])