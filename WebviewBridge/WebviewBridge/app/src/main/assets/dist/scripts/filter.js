/**
 * Created by sunjie on 2016/06/24.
 */
angular.module('phoneNumberFilter', [])
    .filter('phoneNumberFilter', function() {
        return function(input) {
            return input.replace(/tank/, "=====")
        };
    });