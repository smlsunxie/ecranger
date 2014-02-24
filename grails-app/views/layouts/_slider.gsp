                  <g:if test="${files.size()>0}">
                    <div class="flexslider slider1">
                      <ul class="slides">
                        <g:each in="${files}" var="file" status="i">
              
                          <li class="slide4">
                              <img alt="" src="/attachment/show?name=${name}&file=${file.name}" />
                              <div class="carousel-caption">
                                  <h2><a href="#">${file.name}</a></h2>
                                  <p></p>
                              </div>
                          </li>

                        </g:each>  
                      </ul>
                    </div>  
                  </g:if>