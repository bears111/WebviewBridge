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
.controller('LoginCtrl',['$scope', '$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state, $data) {
        $scope.formUser = {};
        //执行用户登录操作
        $scope.login = function(){
        if($scope.formUser){
         console.log($scope.formUser.phoneNumber+"_____"+$scope.formUser.password);
         alert($scope.formUser.phoneNumber+"_____"+$scope.formUser.password);
        }
        }


}])
.controller('ModifyPasswordCtrl',['$scope', '$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state, $data) {}])
.controller('RegisterCtrl',['$scope','$ionicPopup', '$timeout', '$state',  '$data', function($scope, $ionicPopup, $timeout, $state , $data) {}])