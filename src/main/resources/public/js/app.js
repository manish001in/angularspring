var userApp = angular.module("userApp", [ 'ngRoute', 'ngResource' ]);

userApp.config(function($routeProvider) {
$routeProvider.when('/', {
controller : 'WelcomeCtrl',
templateUrl : 'welcome.html'
}).when('/user', {
controller : 'UserCtrl',
templateUrl : 'user1.html'
}).otherwise({
redirectTo: '/'
    });
});

// Controller for welcome
userApp.controller("WelcomeCtrl", [ '$scope','UserService', function($scope, UserService) {
$scope.createNewUser = function(){
var user = { 'name':$scope.name};
// Call UserService to create a new user
UserService.createUser ( user, $scope );
// Reset fields values
$scope.name='';
};
} ]);

userApp.controller("UserCtrl", [ '$scope','UserService', '$routeParams', function($scope, UserService, $routeParams) {
$scope.user=UserService.getUser();
/*this.getUser = function ( id, scope ) {
var User = resource('/users/:userId', {userId:'@userId'});
User.get( {userId:id}, function(user){
scope.user = user;
})
}*/

} ]);