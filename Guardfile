# A sample Guardfile
# More info at https://github.com/guard/guard#readme

guard 'coffeescript', :input => 'app/assets/javascripts'

guard 'compass' do
  watch('^src/(.*)\.s[ac]ss')
end

guard 'livereload' do
  watch(%r{grails-app/views/.+\.(gsp)$})
#  watch(%r{grails-app/controllers/.+\.(groovy)$})
end


