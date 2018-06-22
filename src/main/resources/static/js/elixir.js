angular.module('elixir', ['ngResource'])
    .config(['$resourceProvider', function($resourceProvider) {
        // Don't strip trailing slashes from calculated URLs
        $resourceProvider.defaults.stripTrailingSlashes = false;
    }])
    .controller('ElixirController',['$resource', function($resource) {
        var scope = this;
        scope.elixirs = $resource('/api/v1/elixirs').query();
        scope.selected = {};

        scope.recipes = [];

        scope.addRecipes = function() {
            scope.recipes.push({id:scope.selected.id, ingredient:scope.selected.ingredient, quantity:scope.selected.quantity});
            scope.selected = {};
        };

        scope.items = [{
            id: 1,
            ingredient: 'aLabel',
            quantity: 10
        }, {
            id: 2,
            ingredient: 'bLabel',
            quantity: 15
        }];
    }]);