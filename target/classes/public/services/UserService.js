userApp.factory( 'UserService', [ '$resource', function( $resource ){
return new User( $resource );
}] );

function User( resource ) {
this.resource = resource;
this.createUser = function ( user, scope ) {
var User = resource('/');
User.save(user, function(response){
scope.message = response.message;
});
}
}