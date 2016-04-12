'use strict';

angular.module('catalogueApp').controller('itemDetailsCtrl', ['$scope', '$routeParams', '$http', '$location', function($scope, $routeParams, $http, $location){

    document.getElementById("category").className="";
    document.getElementById("item").className="";
    document.getElementById("search").className="";

    $http({
        method: 'GET',
        url: './item'
    }).then(function successCallback(response) {
        angular.forEach(response.data, function (item) {
            verif($routeParams.id, item);
        });
        
        $http({
            method: 'GET',
            url: './categ'
        }).then(function successCallback(response) {
            angular.forEach(response.data, function (categ) {
                if(categ.id == $scope.item.categ.id){
                    $scope.categ = categ;
                }
            });
        }, function errorCallback(response) {
            $scope.message = JSON.stringify(response);
        });
    }, function errorCallback(response) {
        $scope.message = JSON.stringify(response);
    });
    
    $scope.retour = function(){
        $location.path('/search');
    };

    function verif(id, item){
        if (id == item.id){
            $scope.item = item;
            return;
        }
        return;
    };

}]);
